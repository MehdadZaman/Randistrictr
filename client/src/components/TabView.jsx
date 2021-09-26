import { useState } from 'react';
import { Tabs, TabList, TabPanels, Tab, TabPanel } from '@chakra-ui/react';
import FilterDistricts from './filter-districts';
import DistrictingPreview from './DistrictingPreview';

const TabView = ({ selectedState }) => {
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
            {selectedState ? (
              <h1>Filter for {selectedState} districts</h1>
            ) : (
              <h1 style={{ fontSize: '3vh', transform: 'translateY(350%)' }}>
                Please select a state to continue
              </h1>
            )}
            {selectedState ? (
              <FilterDistricts onFilter={() => setTabIndex(1)} />
            ) : null}
          </div>
        </TabPanel>
        <TabPanel>
          <DistrictingPreview />
        </TabPanel>
      </TabPanels>
    </Tabs>
  );
};

export default TabView;
