import { React, useState } from 'react';
import {
  Box,
  Button,
  Text,
  Heading,
  Tabs,
  TabList,
  TabPanels,
  Tab,
  TabPanel,
  Select,
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

const DistrictingDetails = ({
  data,
  enactedDistrictingPlanStatistics,
  districtingPlanStatistics,
  selectedState,
  popMeasure,
  isDistrictSelected,
  showBoxAndWhiskerPlot,
}) => {
  const [tabIndex, setTabIndex] = useState(0);

  console.log('DATA', data);
  function addAccordianItems() {
    const districts = data.features;
    let retVal = [];
    for (let i = 1; i <= districts.length; i++) {
      const district = districts[i - 1];
      const districtData = [
        {
          title: 'White',
          value: district.properties[`${popMeasure}_WHITE`],
          color: '#7400B8',
        },
        {
          title: 'Black or African American',
          value: district.properties[`${popMeasure}_BLACK`],
          color: '#5E60CE',
        },
        {
          title: 'Hispanic or Latino',
          value: district.properties[`${popMeasure}_HISPANIC`],
          color: '#4EA8DE',
        },
        {
          title: 'Asian',
          value: district.properties[`${popMeasure}_ASIAN`],
          color: '#56CFE1',
        },
        {
          title: 'Other',
          value: district.properties[`${popMeasure}_OTHER`],
          color: '#64DFDF',
        },
        {
          title: 'American Indian',
          value: district.properties[`${popMeasure}_AMERICANINDIAN`],
          color: '#64DFDF',
        },
        {
          title: 'Hawaiian',
          value: district.properties[`${popMeasure}_HAWAIIAN`],
          color: '#64DFDF',
        },
      ];
      console.log(districtData);
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
            <PieChart data={districtData} />
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
                  <Td>{district.properties.DEMOCRAT}%</Td>
                </Tr>
                <Tr>
                  <Td>Republican</Td>
                  <Td>{district.properties.REPUBLICAN}%</Td>
                </Tr>
              </Tbody>
            </Table>
          </AccordionPanel>
        </AccordionItem>
      );
    }
    return retVal;
  }

  const dataB = [
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

  const ComparisonTable = () => {
    console.log(districtingPlanStatistics);
    console.log(enactedDistrictingPlanStatistics);

    const enactedAbsoluteDifferenceInPopulation =
      enactedDistrictingPlanStatistics[
        `${popMeasure.toLowerCase()}AbsoluteDifferenceInPopulation`
      ];
    const enactedEfficiencyGap =
      enactedDistrictingPlanStatistics[
        `${popMeasure.toLowerCase()}EfficiencyGap`
      ];
    const enactedNumOpportunityDistricts =
      enactedDistrictingPlanStatistics[
        `${popMeasure.toLowerCase()}NumOpportunityDistricts`
      ];
    const enactedObjectiveFunctionScore =
      enactedDistrictingPlanStatistics[
        `${popMeasure.toLowerCase()}ObjectiveFunctionScore`
      ];
    const enactedPopulationScore =
      enactedDistrictingPlanStatistics[
        `${popMeasure.toLowerCase()}PopulationScore`
      ];

    // const {
    //   absoluteDifferenceInPopulation: enactedAbsoluteDifferenceInPopulation,
    //   description: enactedDescription,
    //   efficiencyGap: enactedEfficiencyGap,
    //   id: enactedId,
    //   numCongressionalDistricts: enactedNumCongressionalDistricts,
    //   numOpportunityDistricts: enactedNumOpportunityDistricts,
    //   objectiveFunctionScore: enactedObjectiveFunctionScore,
    //   populationScore: enactedPopulationScore,
    //   redistrictNumber: enactedRedistrictNumber,
    //   state: enactedState,
    // } = enactedDistrictingPlanStatistics;

    const absoluteDifferenceInPopulation =
      districtingPlanStatistics[
        `${popMeasure.toLowerCase()}AbsoluteDifferenceInPopulation`
      ];
    const efficiencyGap =
      districtingPlanStatistics[`${popMeasure.toLowerCase()}EfficiencyGap`];
    const numOpportunityDistricts =
      districtingPlanStatistics[
        `${popMeasure.toLowerCase()}NumOpportunityDistricts`
      ];
    const objectiveFunctionScore =
      districtingPlanStatistics[
        `${popMeasure.toLowerCase()}ObjectiveFunctionScore`
      ];
    const populationScore =
      districtingPlanStatistics[`${popMeasure.toLowerCase()}PopulationScore`];

    // const {
    //   absoluteDifferenceInPopulation,
    //   description,
    //   efficiencyGap,
    //   id,
    //   numCongressionalDistricts,
    //   numOpportunityDistricts,
    //   objectiveFunctionScore,
    //   populationScore,
    //   redistrictNumber,
    //   state,
    // } = districtingPlanStatistics;

    return (
      <Table variant='simple' size='sm'>
        <TableCaption>
          Simulated Redistricting statistics vs enacted districting statistics
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
            <Td isNumeric>{numOpportunityDistricts}</Td>
            <Td isNumeric>{enactedNumOpportunityDistricts}</Td>
          </Tr>

          <Tr>
            <Td>Difference between least and most populous districts</Td>
            <Td isNumeric>{absoluteDifferenceInPopulation}%</Td>
            <Td isNumeric>{enactedAbsoluteDifferenceInPopulation}%</Td>
          </Tr>

          <Tr>
            <Td>Efficiency Gap Measure</Td>
            <Td isNumeric>{efficiencyGap}</Td>
            <Td isNumeric>{enactedEfficiencyGap}</Td>
          </Tr>

          <Tr>
            <Td>Population Score</Td>
            <Td isNumeric>{populationScore}</Td>
            <Td isNumeric>{enactedPopulationScore}</Td>
          </Tr>

          <Tr>
            <Td>Population Score</Td>
            <Td isNumeric>{objectiveFunctionScore}</Td>
            <Td isNumeric>{enactedObjectiveFunctionScore}</Td>
          </Tr>

          {/* <Tr>
            <Td>Geometric Pactness [BRUH]</Td>
            <Td isNumeric>0.98</Td>
            <Td isNumeric>0.47</Td>
          </Tr>

          <Tr>
            <Td>Poslby Popper Score [BRUH]</Td>
            <Td isNumeric>0.96</Td>
            <Td isNumeric>0.87</Td>
          </Tr>

          <Tr>
            <Td>Partisan Symmetry Score [BRUH]</Td>
            <Td isNumeric>88%</Td>
            <Td isNumeric>71%</Td>
          </Tr>

          <Tr>
            <Td>Republican Districts [BRUH]</Td>
            <Td isNumeric>3</Td>
            <Td isNumeric>5</Td>
          </Tr>

          <Tr>
            <Td>Democratic Districts [BRUH]</Td>
            <Td isNumeric>5</Td>
            <Td isNumeric>3</Td>
          </Tr> */}
        </Tbody>
      </Table>
    );
  };
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
              Population: {}
            </Text>
            <Button onClick={showBoxAndWhiskerPlot}>
              Show Box and Whisker Plot
            </Button>
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
                {/* <PieChart data={data} /> */}
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
                <Accordion>
                  {data && data.features ? addAccordianItems() : null}
                </Accordion>
              </TabPanel>
              <TabPanel>
                {districtingPlanStatistics &&
                enactedDistrictingPlanStatistics ? (
                  <ComparisonTable />
                ) : null}
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
