package com.example.signup.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.signup.dto.LoginDto;
import com.example.signup.dto.UserDto;
import com.example.signup.entity.User;
import com.example.signup.repository.UserRepo;

@Service

public class UserService {
	@Autowired
    UserRepo userRepository;
  @Autowired
    ModelMapper modelMapper;


  public void saveUser(UserDto userDto) {


      userRepository.save(userDtotouser(userDto));
   }

   public UserDto signupByEmail(String emailId){

      User user = this.userRepository.findByEmailId(emailId);

      return userTouserDto(user);

  }

  //@Bean
   public String login(LoginDto loginDto) {

       User user = this.userRepository.findOneByIgnoreCaseEmailIdAndPassword(loginDto.getEmailId(), loginDto.getPassword());

       if(user==null)
           return "Not Login";
       else
           return "logged In";
  }

   public UserDto userTouserDto(User user) {
  UserDto userDto=this.modelMapper.map(user,UserDto.class);
       return userDto;
   }

   public User userDtotouser(UserDto userDto) {
       User user =this.modelMapper.map(userDto,User.class);
       return user;
   }

}



