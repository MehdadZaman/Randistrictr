import { useState } from 'react';
import { Tabs, TabList, TabPanels, Tab, TabPanel } from '@chakra-ui/react';
import DistrictingPreview from './DistrictingPreview';

const TabView = () => {
  const [tabIndex, setTabIndex] = useState(0);

  console.log('Tabindex', tabIndex);
  return (
    <Tabs index={tabIndex} onChange={(index) => setTabIndex(index)}>
      <TabList>
        <Tab>Filter District</Tab>
        <Tab>Select District</Tab>
      </TabList>
      <TabPanels>
        <TabPanel>
          <button onClick={() => setTabIndex(1)}>Filter</button>
        </TabPanel>
        <TabPanel>
          <DistrictingPreview />
        </TabPanel>
      </TabPanels>
    </Tabs>
  );
};

export default TabView;
