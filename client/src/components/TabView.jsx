import React, { useState, useEffect } from 'react';
import {
  Tabs,
  TabList,
  TabPanels,
  Tab,
  TabPanel,
  Heading,
} from '@chakra-ui/react';
import FilterDistricts from './filter-districts';
import DistrictingPreview from './DistrictingPreview';
import MarylandRedistricting from '../assets/maryland-redistricting.png';
import MichiganRedistricting from '../assets/michigan-redistricting.png';
import UtahRedistricting from '../assets/utah-redistricting.png';
import RunAlgorithm from './run-algorithm';

const TabView = ({
  districtings,
  selectedState,
  popMeasure,
  isDistrictSelected,
  onSelect,
  onRun,
  onStop,
  algorithmStarted,
  algorithmRunning,
  algorithmSummary,
  checkStatus,
}) => {
  const [tabIndex, setTabIndex] = useState(0);

  // const generateDummyCards = (numCards) => {
  //   let cards = [];
  //   let imageUrl;
  //   if (selectedState === 'Maryland') {
  //     imageUrl = MarylandRedistricting;
  //   } else if (selectedState === 'Michigan') {
  //     imageUrl = MichiganRedistricting;
  //   } else {
  //     imageUrl = UtahRedistricting;
  //   }
  //   // let minMax = ['minimized', 'maximized']
  //   // let types = ['the number of majority minority districts', 'the population score']
  //   for (let i = 1; i <= numCards; i++) {
  //     cards.push({
  //       number: i,
  //       imageUrl,
  //       imageAlt: selectedState,
  //       title: `Random Districting ${i}`,
  //       description:
  //         'This districting minimized the number of majority minority districts.',
  //       congressionalDistricts: Math.floor(Math.random() * (15 - 5 + 1)) + 5,
  //       votingDistricts: Math.floor(Math.random() * (9000 - 5000 + 1)) + 5000,
  //       minorityMajorityDistrict: 3,
  //       threshold: 50,
  //       maxPopulationRange: 137429,
  //       populationScore: 86,
  //       efficiencyGapMeasure: 0.44,
  //       polsbyPopperScore: 0.42,
  //     });
  //   }
  //   return cards;
  // };

  // useEffect(() => {
  //   setCards(generateDummyCards(30));
  // }, [selectedState]);

  return (
    <Tabs index={tabIndex} onChange={(index) => setTabIndex(index)}>
      <TabList>
        {/* <Tab>Filter District</Tab> */}
        <Tab>Select Districting Plan</Tab>
        <Tab isDisabled={!isDistrictSelected}>Run Algorithm</Tab>
      </TabList>
      <TabPanels style={{ overflowY: 'auto', height: '100%' }}>
        {/* <TabPanel>
          <Heading size='md'>Filters for {selectedState} districts</Heading>
          <FilterDistricts
            onFilter={() => {
              setCards(generateDummyCards(6));
              setTabIndex(1);
            }}
          />
        </TabPanel> */}
        <TabPanel style={{ overflowY: 'hidden', height: '100%' }}>
          <Heading size='md'>
            {districtings.length} redistrictings generated
          </Heading>
          <DistrictingPreview
            cards={districtings}
            popMeasure={popMeasure}
            onSelect={onSelect}
          />
        </TabPanel>
        <TabPanel>
          <RunAlgorithm
            onRun={onRun}
            onStop={onStop}
            algorithmStarted={algorithmStarted}
            algorithmRunning={algorithmRunning}
            algorithmSummary={algorithmSummary}
            checkStatus={checkStatus}
          />
        </TabPanel>
      </TabPanels>
    </Tabs>
  );
};

export default TabView;
