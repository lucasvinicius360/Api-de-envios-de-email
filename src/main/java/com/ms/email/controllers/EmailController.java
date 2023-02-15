package com.ms.email.controllers;

import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.email.dtos.EmailDto;
import com.ms.email.models.EmailModel;
import com.ms.email.repositories.EmailRepository;
import com.ms.email.services.EmailServices;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
public class EmailController {
    
    @Autowired
    EmailServices emailServices;

    @Autowired
    private EmailRepository emailRepository;



    @ResponseBody
	@Transactional
    @RequestMapping(path = "/sending-email", method = RequestMethod.POST)
    public ResponseEntity<EmailModel> sendingEmail( @RequestBody @Valid EmailDto emailDto){
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties( emailModel,emailDto);
        System.out.println(emailModel);
        System.out.println(emailDto);
        emailServices.sendEmail(emailModel);
        return new ResponseEntity<>(emailModel,HttpStatus.CREATED);
    }


    @ResponseBody
	@Transactional
	@RequestMapping(path = "/livros", method = RequestMethod.POST)
	public ResponseEntity<EmailModel> salvar(@RequestBody EmailModel livro){
        
        livro.setSendDateEmail(LocalDateTime.now(ZoneId.of("UTC")));
        emailServices.sendEmail(livro);

        // this.emailRepository.save(livro);

        return new ResponseEntity<>(livro,HttpStatus.CREATED);

    }

		
}
