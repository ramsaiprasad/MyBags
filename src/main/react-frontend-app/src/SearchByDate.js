import * as React from 'react';
import Paper from '@mui/material/Paper';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TablePagination from '@mui/material/TablePagination';
import TableRow from '@mui/material/TableRow';
import Axios from 'axios';
import { useEffect } from 'react';
import { Button, TextField } from '@mui/material';
import axios from 'axios';
const columns = [
  { id: 'vehicleNo', label: 'Vehical Number', minWidth: 170 },
  { id: 'ld', label: 'Date', minWidth: 100 },
  {
    id: 'phoneNumber',
    label: 'Phone Number',
    minWidth: 170,
    align: 'right',
    format: (value) => value.toLocaleString('en-US'),
  },
  {
    id: 'bags',
    label: 'Bags',
    minWidth: 170,
    align: 'right',
    format: (value) => value.toLocaleString('en-US'),
  },
  {
    id: 'noofPoints',
    label: 'POINTS',
    minWidth: 170,
    align: 'right',
    format: (value) => value.toLocaleString('en-US'),
  },
  
];





export default function SearchByDate() {
  const [page, setPage] = React.useState(0);
  const [rowsPerPage, setRowsPerPage] = React.useState(10);
  const[rows,setRows]=React.useState([]);
  const[startDate,setStartDate]=React.useState('');
  const[endDate,setEndDate]=React.useState('')
  
  const handleChangePage = (event, newPage) => {
    setPage(newPage);
  };
  useEffect( ()=>{
    
    
  },[]);

  const handleChangeRowsPerPage = (event) => {
    setRowsPerPage(+event.target.value);
    setPage(0);
  };

  const handleOnchangeStartDate=(e)=>
  {
      setStartDate(e.target.value);
  }
  const handleOnchangeEndDate=(e)=>
  {
      setEndDate(e.target.value);
  }

  const submitDates=(e)=>
  {
    
    const param1=startDate;
    const param2=endDate;

    axios.get('http://localhost:8090/api/test/getByDate/'+param1+"/"+param2).then((res)=>
    {    
        setRows(res.data)
    })
   
   
    
  }
  const submitOnclear=()=>
  {
    setRows([]);
    setStartDate('');
    setEndDate('');
  }
  return (
    <Paper  sx={{ width: '100%' }}>
        <TextField type={"date"} value={startDate} placeholder="Enter Start Date" onChange={handleOnchangeStartDate} Style={"margin:10px"}></TextField>
        <TextField type={"date"} value={endDate} placeholder="Enter End Date" onChange={handleOnchangeEndDate} Style={"margin:10px"}></TextField><br /><br />


        <Button variant='contained' color='success' onClick={submitDates} >Submit</Button>
        <Button variant='contained' color='warning' onClick={submitOnclear} Style={"margin:20px"}>Clear</Button>
      <TableContainer  sx={{ maxHeight: 440 }}>

        <Table stickyHeader aria-label="sticky table">
          <TableHead>
            
            <TableRow>
              <TableCell align="center" colSpan={6}>
                All Data
              </TableCell>
            </TableRow>
            <TableCell align="left" colSpan={6}>
                <Button variant='contained'>Export To Excel</Button>
              </TableCell>
            <TableRow>
              {columns.map((column) => (
                <TableCell
                  key={column.id}
                  align={column.align}
                  style={{ top: 57, minWidth: column.minWidth }}
                >
                  {column.label}
                </TableCell>
              ))}
            </TableRow>
          </TableHead>
          <TableBody>
            {rows
              .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
              .map((row) => {
                return (
                  <TableRow hover role="checkbox" tabIndex={-1} key={row.code}>
                    {columns.map((column) => {
                      const value = row[column.id];
                      return (
                        <TableCell key={column.id} align={column.align}>
                          {column.format && typeof value === 'number'
                            ? column.format(value)
                            : value}    
                        </TableCell>
                      );
                    })}
                  </TableRow>
                );
              })}
          </TableBody>
        </Table>
      </TableContainer>
      <TablePagination
        rowsPerPageOptions={[10, 25]}
        component="div"
        count={rows.length}
        rowsPerPage={rowsPerPage}
        page={page}
        onPageChange={handleChangePage}
        onRowsPerPageChange={handleChangeRowsPerPage}
      />
    </Paper>
  );
}