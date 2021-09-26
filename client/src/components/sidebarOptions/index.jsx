import { useState } from 'react';
import './index.css';

import {
  Slider,
  SliderTrack,
  SliderFilledTrack,
  SliderThumb,
  Select,
  Input,
  Button
} from "@chakra-ui/react"

const SidebarOptions = ({ map }) => {
  const [minMinorityMajorityDistricts, setminMinorityMajorityDistricts] = useState(3);
  const [maxMinorityMajorityDistricts, setmaxMinorityMajorityDistricts] = useState(3);

  const [minThreshold, setMinThreshold] = useState(50);
  const [minPopulationScore, setMinPopulationScore] = useState(75);

  const [maxDiff, setMaxDiff] = useState();

  const [efficiencyGapMeasure, setEfficiencyGapMeasure] = useState(0);
  const [polsbyPopperScore, setPolsbyPopperScore] = useState(0);

  function handleSubmitFilter() {
    console.log('You clicked submit.');
    if (!efficiencyGapMeasure || !polsbyPopperScore) {
      console.log("Please fill in all filters");
    }
    else {
      console.log("You good");
    }
  }

  return (
    <>
      <div style={{ margin: "2vh" }}>
        <h1><span style={{ color: "gray" }}>Minimum Majority-Minority districts: </span> <span style={{ marginLeft: "1vh" }}> {minMinorityMajorityDistricts} </span></h1>
        <Slider aria-label="slider-ex-2" colorScheme="blue" defaultValue={minMinorityMajorityDistricts} max={5} onChangeEnd={(val) => {
          setminMinorityMajorityDistricts(val);
          setmaxMinorityMajorityDistricts(Math.max(val, maxMinorityMajorityDistricts));
        }}>
          <SliderTrack>
            <SliderFilledTrack />
          </SliderTrack>
          <SliderThumb />
        </Slider>
      </div>

      <div style={{ margin: "2vh" }}>
        <h1><span style={{ color: "gray" }}>Maximum Majority-Minority districts: </span> <span style={{ marginLeft: "1vh" }}> {maxMinorityMajorityDistricts} </span></h1>
        <Slider aria-label="slider-ex-2" colorScheme="blue" defaultValue={maxMinorityMajorityDistricts} max={5} onChangeEnd={(val) => {
          setmaxMinorityMajorityDistricts(val);
          setminMinorityMajorityDistricts(Math.min(minMinorityMajorityDistricts, val));
        }}>
          <SliderTrack>
            <SliderFilledTrack />
          </SliderTrack>
          <SliderThumb />
        </Slider>
      </div>

      <div style={{ margin: "2vh" }}>
        <h1><span style={{ color: "gray" }}>Minimum Threshold for Majority-Minority districts: </span> <span style={{ marginLeft: "1vh" }}> {minThreshold}</span>%</h1>
        <Slider aria-label="slider-ex-2" colorScheme="blue" defaultValue={minThreshold} max={100} onChangeEnd={(val) => setMinThreshold(val)}>
          <SliderTrack>
            <SliderFilledTrack />
          </SliderTrack>
          <SliderThumb />
        </Slider>
      </div>

      <div style={{ margin: "2vh" }}>
        <h1><span style={{ color: "gray" }}>Maximum absolute difference between most and least populous districts: </span></h1>
        <Select variant="outline" placeholder="Select percentage" style={{ marginTop: "1vh" }} onChange={(event) => {
          setMaxDiff(event.target.value);
        }}>
          <option value="0.1%" >0.1%</option>
          <option value="0.2%" >0.2%</option>
          <option value="0.3%" >0.3%</option>
          <option value="0.4%" >0.4%</option>
          <option value="0.5%" >0.5%</option>
        </Select>
      </div>

      <div style={{ margin: "2vh" }}>
        <h1><span style={{ color: "gray" }}>Minimum Population Score: </span> <span style={{ marginLeft: "1vh" }}> {minPopulationScore}</span>%</h1>
        <Slider aria-label="slider-ex-2" colorScheme="blue" defaultValue={minPopulationScore} max={100} onChangeEnd={(val) => setMinPopulationScore(val)}>
          <SliderTrack>
            <SliderFilledTrack />
          </SliderTrack>
          <SliderThumb />
        </Slider>
      </div>


      <div style={{ margin: "2vh" }}>
        <h1 style={{ marginBottom: "1vh" }}><span style={{ color: "gray" }}>Maximum Efficiency Gap Measure: </span></h1>
        <Input variant="outline" placeholder="" type="number" onChange={(event) => {
          //if (event)
          setEfficiencyGapMeasure(event.target.value);
        }
        } />
      </div>

      <div style={{ margin: "2vh" }}>
        <h1 style={{ marginBottom: "1vh" }}><span style={{ color: "gray" }}>Geometric Pactness Polsby Popper Score: </span></h1>
        <Input variant="outline" placeholder="" type="number" onChange={(event) => {
          //if (event)
          setPolsbyPopperScore(event.target.value);
        }
        } />
      </div>

      <div style={{ margin: "4vh" }}>
        <Button colorScheme="blue" size="lg" onClick={handleSubmitFilter}>Filter</Button>
      </div>
    </>
  );
};

export default SidebarOptions;
