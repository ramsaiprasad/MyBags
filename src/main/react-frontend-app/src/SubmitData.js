import React, { Component } from 'react'
import {Box,Button,TextField,Typography} from'@mui/material'
import Axios from 'axios';
import axios from 'axios';
export default class SubmitData extends Component {
  constructor(prop)
  {
      super(prop);
      this.state={
        vehicleNo:'',
        phoneNumber:'',
        noofpoints:'',
        bagscount:0,
        data:[]
      }
      this.handleOnChangePoints=this.handleOnChangePoints.bind(this);
      this.handleOnchangeBAgsCount=this.handleOnchangeBAgsCount.bind(this);
      this.handleOnchangeVehical=this.handleOnchangeVehical.bind(this);
      this.handleonchangePhoneNumber=this.handleonchangePhoneNumber.bind(this);
    }

      
      handleOnchangeVehical=(e)=>
      {
          this.setState({vehicleNo:e.target.value})
      }
      handleOnChangePoints=(e)=>
      {
        this.setState({noofpoints:e.target.value})
      }
      handleOnchangeBAgsCount=(e)=>
      {
        this.setState({bagscount:e.target.value})
      }
      handleonchangePhoneNumber=(e)=>
      {
        this.setState({phoneNumber:e.target.value})
      }
      handleSubmitData=()=>
      {
          var vehicleNo='';
          var bagscount='';
          var phoneNumber='';
          var noofpoints='';

         if(this.state.vehicleNo!=null && this.state.vehicleNo.length>18)
         {
           vehicleNo=this.state.vehicleNo;
           
         }  
         else{
          console.log(vehicleNo)
          window.alert("Vehical Number Can not be Null or Should be lessthan 18")
         }  
         if(this.state.bagscount!=null && this.state.bagscount.length>0)
         {
          bagscount=this.state.bagscount;
         }
         else{
          window.alert("bagsCount Can not be null or can not be negative")
         }
        if(this.state.phoneNumber.length==10 && this.state.phoneNumber!=null)
        {
          phoneNumber=this.state.phoneNumber;
        }
        else{
          window.alert("phone number Length should be only 10 digits")
        }
        
         
          if(this.state.noofpoints<=-1 || this.state.noofpoints!=null)
          {
             noofpoints=this.state.noofpoints;
          }
          else{
            window.alert("No of Points can not be Negative or Null")
          }
             this.setState({data:{
              "vehicleNo":this.state.vehicleNo,
               "bagscount":this.state.bagscount,
               "phoneNumber":this.state.phoneNumber,
               "noofpoints":this.state.noofpoints

             }})
             if(this.state.data==null)
             {
             axios.post(`http://localhost:8090/api/test/saveData`,this.state.data).then((res)=>
             {
                console.log(res.data);
                window.location.reload();
             })
            }
            else{
              window.alert("data is Empty")
              window.location.reload();
            }
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
            <Typography variant='h5' padding={3} textAlign="center">Submit Data</Typography>
         <TextField margin='normal' onChange={this.handleOnchangeVehical} type={"text"} variant="outlined" placeholder='Enter vehicleNo'></TextField>
            <TextField margin='normal' onChange={this.handleOnchangeBAgsCount}  type={"text"} variant="outlined" placeholder='Enter bagscount'/>
            <TextField margin='normal' onChange={this.handleonchangePhoneNumber}  type={"text"} variant="outlined" placeholder='Enter phoneNumber' />
            <TextField margin='normal' onChange={this.handleOnChangePoints}  type={"text"} variant="outlined" placeholder='Enter Points' />
            <Button variant='contained'color='success' onClick={this.handleSubmitData}>Submit</Button>
            
            </Box>
          </form>

         
      </div>
    )
  }
}
