import { React, useState } from 'react';
import {
  Box,
  Text,
  Tabs, 
  TabList, 
  TabPanels, 
  Tab, 
  TabPanel,
  Stack,
} from '@chakra-ui/react';

const DistrictingDetails = ({selectedState}) => {
  const [tabIndex, setTabIndex] = useState(0);
  return (
    <Box p={1}>
      {selectedState ? (
        <Box>
          <Stack spacing={0.25} m={2}> {/*ADD THE STATE FLAG*/}
            <Text fontSize='4xl' as="b">{selectedState}</Text>
            <Text fontSize='1xl' as="i">Number of Congressional Districts: 8</Text>
            <Text fontSize='1xl' as="i">Population: 6,065,436</Text>
          </Stack>

          <Tabs index={tabIndex} onChange={(index) => setTabIndex(index)}>
          <TabList>
            <Tab>Population</Tab>
            <Tab>Districting</Tab>
            <Tab>Government</Tab>
          </TabList>
          <TabPanels>
            <TabPanel>
              <div>I like big census data</div>
            </TabPanel>
            <TabPanel>
              <div>Graph data cannot lie</div>
            </TabPanel>
            <TabPanel>
              <div>Donald Trump won!</div>
            </TabPanel>
          </TabPanels>
        </Tabs>
        </Box>
      ) : (
        <h1 style={{ display: "flex", justifyContent: "center", fontSize: '3vh', transform: 'translateY(350%)' }}>
          Please select a state to continue
        </h1>
      )}
    </Box>
  );
};

export default DistrictingDetails;