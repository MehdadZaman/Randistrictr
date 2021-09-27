import { React, useState } from 'react';
import {
  Box,
  Text,
  Heading,
  Tabs,
  TabList,
  TabPanels,
  Tab,
  TabPanel,
  Stack,
  Table,
  Thead,
  Tbody,
  Tfoot,
  Tr,
  Th,
  Td,
  TableCaption,
  Accordion,
  AccordionItem,
  AccordionButton,
  AccordionPanel,
  AccordionIcon,
} from '@chakra-ui/react';
// import { PieChart } from 'react-minimal-pie-chart';
import PieChart from './PieChart';

const DistrictingDetails = ({ selectedState, isDistrictSelected }) => {
  const [tabIndex, setTabIndex] = useState(0);

  function addAccordianItems() {
    let retVal = [];

    for (let i = 1; i <= 8; i++) {
      retVal.push(
        <AccordionItem key={i}>
          <h2>
            <AccordionButton>
              <Box flex='1' textAlign='left'>
                District # {i} statistics
              </Box>
              <AccordionIcon />
            </AccordionButton>
          </h2>
          <AccordionPanel paddingX={0} pb={4}>
            <Heading size='md' textAlign='center'>
              Population Percentage Per Race
            </Heading>
            <PieChart data={data} />
            <Heading size='md' mb={5} textAlign='center'>
              Population Percentage Per Political Party
            </Heading>
            <Table
              style={{
                paddingLeft: '0vh',
                paddingRight: '0vh',
                paddingTop: '2vh',
              }}
              variant='simple'
              size='sm'
            >
              <Thead>
                <Tr style={{ textAlign: 'center' }}>
                  <Th>Political Party</Th>
                  <Th>Percentage of Votes</Th>
                </Tr>
              </Thead>
              <Tbody>
                <Tr>
                  <Td>Democratic</Td>
                  <Td>52.5%</Td>
                </Tr>
                <Tr>
                  <Td>Republican</Td>
                  <Td>47.5%</Td>
                </Tr>
              </Tbody>
            </Table>
          </AccordionPanel>
        </AccordionItem>
      );
    }

    return retVal;
  }

  const data = [
    {
      title: 'White',
      value: 50,
      color: '#7400B8',
    },
    {
      title: 'Black or African American',
      value: 31.1,
      color: '#5E60CE',
    },
    {
      title: 'Hispanic or Latino',
      value: 10.6,
      color: '#4EA8DE',
    },
    {
      title: 'Asian',
      value: 6.7,
      color: '#56CFE1',
    },
    {
      title: 'Other',
      value: 1.6,
      color: '#64DFDF',
    },
    // {
    //   title: 'Two or more races',
    //   value: 1.6,
    //   color: '#80FFDB',
    // },
  ];
  return (
    <Box p={1}>
      {selectedState ? (
        <Box>
          <Stack spacing={0.25} m={2}>
            {' '}
            {/*ADD THE STATE FLAG*/}
            <Text fontSize='4xl' as='b'>
              {selectedState}
            </Text>
            <Text fontSize='1xl' as='i'>
              Number of Congressional Districts: 8
            </Text>
            <Text fontSize='1xl' as='i'>
              Population: 6,065,436
            </Text>
          </Stack>

          <Tabs index={tabIndex} onChange={(index) => setTabIndex(index)}>
            <TabList>
              <Tab>Population</Tab>
              <Tab isDisabled={!isDistrictSelected}>Districting</Tab>
              <Tab isDisabled={!isDistrictSelected}>Statistics</Tab>
            </TabList>
            <TabPanels>
              <TabPanel>
                <Heading size='md' textAlign='center'>
                  Population Percentage Per Race
                </Heading>
                <PieChart data={data} />
                <Heading size='md' mb={5} textAlign='center'>
                  Population Percentage Per Political Party
                </Heading>
                <Table
                  style={{
                    paddingLeft: '0vh',
                    paddingRight: '0vh',
                    paddingTop: '2vh',
                  }}
                  variant='simple'
                  size='sm'
                >
                  <Thead>
                    <Tr style={{ textAlign: 'center' }}>
                      <Th>Political Party</Th>
                      <Th>Percentage of Votes</Th>
                    </Tr>
                  </Thead>
                  <Tbody>
                    <Tr>
                      <Td>Democratic</Td>
                      <Td>52.5%</Td>
                    </Tr>
                    <Tr>
                      <Td>Republican</Td>
                      <Td>47.5%</Td>
                    </Tr>
                  </Tbody>
                </Table>
              </TabPanel>
              <TabPanel>
                <Accordion>{addAccordianItems()}</Accordion>
              </TabPanel>
              <TabPanel>
                <Table variant='simple' size='sm'>
                  <TableCaption>
                    Simulated Redistricting statistics vs enacted districting
                    statistics
                  </TableCaption>
                  <Thead>
                    <Tr>
                      <Th></Th>
                      <Th>Simulated redistricting</Th>
                      <Th>Enacted districting</Th>
                    </Tr>
                  </Thead>
                  <Tbody>
                    <Tr>
                      <Td>Majority Minority Districts</Td>
                      <Td isNumeric>2</Td>
                      <Td isNumeric>5</Td>
                    </Tr>

                    <Tr>
                      <Td>
                        Difference between least and most populous districts
                      </Td>
                      <Td isNumeric>0.1%</Td>
                      <Td isNumeric>0.5%</Td>
                    </Tr>

                    <Tr>
                      <Td>Geometric Pactness</Td>
                      <Td isNumeric>0.98</Td>
                      <Td isNumeric>0.47</Td>
                    </Tr>

                    <Tr>
                      <Td>Poslby Popper Score</Td>
                      <Td isNumeric>0.96</Td>
                      <Td isNumeric>0.87</Td>
                    </Tr>

                    <Tr>
                      <Td>Partisan Symmetry Score</Td>
                      <Td isNumeric>88%</Td>
                      <Td isNumeric>71%</Td>
                    </Tr>

                    <Tr>
                      <Td>Republican Districts</Td>
                      <Td isNumeric>3</Td>
                      <Td isNumeric>5</Td>
                    </Tr>

                    <Tr>
                      <Td>Democratic Districts</Td>
                      <Td isNumeric>5</Td>
                      <Td isNumeric>3</Td>
                    </Tr>
                  </Tbody>
                </Table>
              </TabPanel>
            </TabPanels>
          </Tabs>
        </Box>
      ) : (
        <h1
          style={{
            display: 'flex',
            justifyContent: 'center',
            fontSize: '3vh',
            transform: 'translateY(350%)',
          }}
        >
          Please select a state to continue
        </h1>
      )}
    </Box>
  );
};

export default DistrictingDetails;
