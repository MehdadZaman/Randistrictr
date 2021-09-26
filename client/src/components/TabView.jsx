import { useState } from 'react';
import { Tabs, TabList, TabPanels, Tab, TabPanel } from '@chakra-ui/react';
import FilterDistricts from './filter-districts';
import DistrictingPreview from './DistrictingPreview';

const TabView = ({ selectedState, onSelect }) => {
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
          <div style={{ textAlign: 'center' }}>
            <h1>Filter for {selectedState} districts</h1>
            <FilterDistricts onFilter={() => setTabIndex(1)} />
          </div>
        </TabPanel>
        <TabPanel>
          <DistrictingPreview onSelect={onSelect} />
        </TabPanel>
      </TabPanels>
    </Tabs>
  );
};

export default TabView;
