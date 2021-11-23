import { useState } from 'react';
import './index.css';

import {
  Slider,
  SliderTrack,
  SliderFilledTrack,
  SliderThumb,
  Select,
  Button,
  NumberInput,
  NumberInputField,
  NumberInputStepper,
  NumberIncrementStepper,
  NumberDecrementStepper,
} from '@chakra-ui/react';
import ReactSlider from 'react-slider';

const RunAlgorithm = ({ map, onRun, algorithmRunning }) => {
  const [[minOpportunity, maxOpportunity], setOpportunity] = useState([0, 3]);
  const [minThreshold, setMinThreshold] = useState(50);
  const [minPopulationScore, setMinPopulationScore] = useState(75);
  const [maxDiff, setMaxDiff] = useState();
  const [maxEffGap, setMaxEffGap] = useState(0.5);
  const [minPolsbyPopper, setMinPolsbyPopper] = useState(0.5);
  const [numIterations, setNumIterations] = useState(10);
  const [isLoading, setIsLoading] = useState(false);

  function handleRun() {
    // if (!efficiencyGapMeasure || !polsbyPopperScore) {
    //   console.log('Please fill in all filters');
    // } else {
    //   onFilter();
    // }
    onRun(
      minOpportunity,
      maxOpportunity,
      minThreshold,
      maxDiff,
      maxEffGap,
      minPolsbyPopper,
      numIterations
    );
  }

  return (
    <>
      <div style={{ margin: '2vh' }}>
        <h1>
          <span style={{ color: 'gray' }}>Majority-Minority Districts: </span>
          <br />
          <span>
            Min: {minOpportunity}, Max: {maxOpportunity}
          </span>
        </h1>

        <ReactSlider
          className='horizontal-slider'
          thumbClassName='thumb'
          trackClassName='track'
          value={[minOpportunity, maxOpportunity]}
          onChange={setOpportunity}
          ariaLabel={['Lower thumb', 'Upper thumb']}
          // ariaValuetext={(state) => `Thumb value ${state.valueNow}`}
          // renderThumb={(props, state) => <div {...props}>{state.valueNow}</div>}
          pearling
          minDistance={0}
          min={0}
          max={5}
        />
      </div>
      {/* <div style={{ margin: '2vh' }}>
        <h1>
          <span style={{ color: 'gray' }}>
            Minimum Threshold for Majority-Minority Districts:
          </span>
          <br />
          <span>{minThreshold}</span>%
        </h1>
        <Slider
          aria-label='slider-ex-2'
          colorScheme='blue'
          defaultValue={minThreshold}
          max={100}
          value={minThreshold}
          onChange={setMinThreshold}
        >
          <SliderTrack>
            <SliderFilledTrack />
          </SliderTrack>
          <SliderThumb />
        </Slider>
      </div> */}

      <div style={{ margin: '2vh' }}>
        <h1>
          <span style={{ color: 'gray' }}>
            Maximum absolute difference between most and least populous
            districts:{' '}
          </span>
        </h1>
        <Select
          variant='outline'
          placeholder='Select percentage'
          style={{ marginTop: '1vh' }}
          value={maxDiff}
          onChange={(event) => {
            setMaxDiff(event.target.value);
          }}
        >
          <option value='0.1%'>0.1%</option>
          <option value='0.2%'>0.2%</option>
          <option value='0.3%'>0.3%</option>
          <option value='0.4%'>0.4%</option>
          <option value='0.5%'>0.5%</option>
        </Select>
      </div>

      {/* <div style={{ margin: '2vh' }}>
        <h1>
          <span style={{ color: 'gray' }}>Minimum Population Score: </span>
          <br />
          <span>{minPopulationScore}</span>%
        </h1>
        <Slider
          aria-label='slider-ex-2'
          colorScheme='blue'
          defaultValue={minPopulationScore}
          max={100}
          value={minPopulationScore}
          onChange={setMinPopulationScore}
        >
          <SliderTrack>
            <SliderFilledTrack />
          </SliderTrack>
          <SliderThumb />
        </Slider>
      </div>

      <div style={{ margin: '2vh' }}>
        <h1 style={{ marginBottom: '1vh' }}>
          <span style={{ color: 'gray' }}>
            Maximum Efficiency Gap Measure:{' '}
          </span>
        </h1>
        <NumberInput
          variant='outline'
          placeholder=''
          type='number'
          min={0}
          max={1}
          step={0.01}
          value={maxEffGap}
          onChange={setMaxEffGap}
        >
          <NumberInputField />
          <NumberInputStepper>
            <NumberIncrementStepper />
            <NumberDecrementStepper />
          </NumberInputStepper>
        </NumberInput>
      </div>

      <div style={{ margin: '2vh' }}>
        <h1 style={{ marginBottom: '1vh' }}>
          <span style={{ color: 'gray' }}>
            Geometric Pactness Polsby Popper Score:{' '}
          </span>
        </h1>
        <NumberInput
          variant='outline'
          placeholder=''
          type='number'
          min={0}
          max={1}
          step={0.01}
          value={minPolsbyPopper}
          onChange={setMinPolsbyPopper}
        >
          <NumberInputField />
          <NumberInputStepper>
            <NumberIncrementStepper />
            <NumberDecrementStepper />
          </NumberInputStepper>
        </NumberInput>
      </div>
      <div style={{ margin: '2vh' }}>
        <h1 style={{ marginBottom: '1vh' }}>
          <span style={{ color: 'gray' }}>Number of Iterations: </span>
        </h1>
        <NumberInput
          variant='outline'
          type='number'
          min={1}
          max={100}
          step={1}
          value={numIterations}
          onChange={(value) => {
            setNumIterations(value);
          }}
        >
          <NumberInputField />
          <NumberInputStepper>
            <NumberIncrementStepper />
            <NumberDecrementStepper />
          </NumberInputStepper>
        </NumberInput>
      </div> */}
      <div style={{ margin: '4vh', textAlign: 'center' }}>
        <Button
          isLoading={algorithmRunning}
          colorScheme='blue'
          size='lg'
          onClick={handleRun}
        >
          Run Algorithm
        </Button>
      </div>
    </>
  );
};

export default RunAlgorithm;
