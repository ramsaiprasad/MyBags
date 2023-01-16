import React, { Component } from 'react'
import LoginIcon from '@mui/icons-material/Login'
import HowToRegTwoToneIcon from '@mui/icons-material/HowToRegTwoTone';
import {Box,Button,TextField,Typography} from'@mui/material'
import axios from 'axios';

import { Navigate } from 'react-router-dom';
export default class Login extends Component {
    constructor(prop)
    {
        super(prop);
        this.state={
            isSignUp:false,
            email:'',
            userName:'',
            password:'',
            isLoggedIn:true,
            
          
        }
        this.handleOnchangeEmail=this.handleOnchangeEmail.bind(this);
        this.handleOnchangeName=this.handleOnchangeName.bind(this);
        this.handleOnchangePassword=this.handleOnchangePassword.bind(this);
        
    }
    componentDidMount=()=>
    {
           
    }

   setSignUp=()=>
    {
        this.setState({isSignUp:!this.state.isSignUp})
        console.log(this.state.isSignUp)
    }
  signup=()=>
  {
     console.log("sign Up")
      const data={"email":this.state.email,
     "userName":this.state.userName,
     "password":this.state.password};
      
     console.log(data)
     const request=JSON.stringify(data);
     axios.post(`http://localhost:8090/api/test/signUp`,data).then((res)=>
     {
      console.log(res.data);
      
        if(res.data=="CREATED")
        {
          this.setState({isSignUp:false});
        }
      
     })

  }
  handleOnchangeName=(e)=>
  {
     this.setState({userName:e.target.value})
     console.log(this.state.userName)
  }
  handleOnchangeEmail=(e)=>
  {
     this.setState({email:e.target.value})
     
  }
  handleOnchangePassword=(e)=>
  {
     this.setState({password:e.target.value})
     
  }
  routee=()=>
  {
    
    
  }
   
  login=()=>
  {
    
    console.log("Log in");
    const data={
      userName:this.state.userName,
      password:this.state.password
    }
    axios.post(`http://localhost:8090/api/test/login`,data).then((res)=>
    {
        localStorage.setItem('isloggedin','true');
        const data=localStorage.getItem('isloggedin');
        console.log(data);
        this.setState({isLoggedIn:false})
        
        window.location.reload();
    })
    return <Navigate to="/signin" />

    
  }
  
  
  render() {
    return (
      <div>
         <form>
       <Box overflow={'hidden'} display="flex" flexDirection={"column"} maxWidth={400} 
            alignItems="center"
            justifyContent={"center"}
            margin="auto"
            marginTop={5}
            padding={5}
            borderRadius={5}
            boxShadow={'5px 5px 10px #ccc'}
            sx={{":hover":{
                boxShadow:"10px 10px 20px #ccc"
            }}}>
        
            <Typography variant='h5' padding={3} textAlign="center">{this.state.isSignUp?"Sign Up":"Login"}</Typography>
          {this.state.isSignUp && <TextField margin='normal' type={"email"} 
          onChange={this.handleOnchangeEmail} 
          variant="outlined" placeholder='Email'></TextField>}
            <TextField
            onChange={this.handleOnchangeName} margin='normal' type={"text"} variant="outlined" placeholder='userName'/>
            <TextField
            onChange={this.handleOnchangePassword} margin='normal' type={"password"} variant="outlined" placeholder='Password' />
            <Button endIcon={this.state.isSignUp?<HowToRegTwoToneIcon />:<LoginIcon />}sx={{marginTop:3 ,borderRadius:3}}variant='contained'
             color='warning'
             onClick={this.state.isSignUp?this.signup:this.login}
             >{this.state.isSignUp?"Sign Up":"Login"}</Button>
            <Button
            
             endIcon={this.state.isSignUp?<LoginIcon />:<HowToRegTwoToneIcon />} onClick={this.setSignUp} 
            sx={{marginTop:3 ,borderRadius:3}}>
            {this.state.isSignUp ? "Login":"Sign Up"}</Button>
            
            </Box>
         </form>
      </div>
    )
  }
}


