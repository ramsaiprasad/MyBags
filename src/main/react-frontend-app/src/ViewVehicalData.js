import { Box } from '@mui/material'
import React, { Component } from 'react'
import ColumnGroupingTable from './ColumnGroupingTable'
import VehicalData from './VehicalData'

export default class 
 extends Component {
  render() {
    return (
      <div>
        <Box overflow={'hidden'}  display="flex" flexDirection={"column"} maxWidth={1000} 
            alignItems="center"
            justifyContent={"center"}
            margin="auto"
            marginTop={5}
            padding={5}
            borderRadius={5}
            boxShadow={'5px 5px 10px #ccc'}
            sx={{":hover":{
                boxShadow:"10px 10px 20px #ccc"
            }}}
        ><VehicalData /></Box>
        

      </div>
    )
  }
}
