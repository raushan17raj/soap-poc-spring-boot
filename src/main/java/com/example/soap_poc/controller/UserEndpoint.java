package com.example.soap_poc.controller;

import com.example.soap_poc.dto.UserDTO;
import com.example.soap_poc.service.UserService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import com.example.soap.gen.GetUserRequest;
import com.example.soap.gen.GetUserResponse;
import com.example.soap.gen.AddUserResponse;
import com.example.soap.gen.AddUserRequest;

@Endpoint
public class UserEndpoint {

    private static final String NAMESPACE = "http://example.com/user";

    private UserService userService;

    public UserEndpoint(UserService userService) {
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUser(@RequestPayload GetUserRequest request) {

        UserDTO user = userService.getUserById(request.getId());

        GetUserResponse response = new GetUserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setMobileNo(user.getMobileNo());

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE, localPart = "addUserRequest")
    @ResponsePayload
    public AddUserResponse addUser(@RequestPayload AddUserRequest addUserRequest){
        UserDTO userDTO = new UserDTO();
        userDTO.setName(addUserRequest.getName());
        userDTO.setEmail(addUserRequest.getEmail());
        userDTO.setMobileNo(addUserRequest.getMobileNo());

        AddUserResponse addUserResponse = new AddUserResponse();
        addUserResponse.setId(userService.addUser(userDTO).getId());
        addUserResponse.setStatus("User Added Successfully");
        return addUserResponse;
    }
}
