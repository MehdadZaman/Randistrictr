import { useState, useEffect } from 'react';
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
  Progress,
} from '@chakra-ui/react';
import ReactSlider from 'react-slider';

const RunAlgorithm = ({
  map,
  onRun,
  onStop,
  algorithmStarted,
  algorithmRunning,
  algorithmSummary,
  checkStatus,
}) => {
  const [[minOpportunity, maxOpportunity], setOpportunity] = useState([0, 3]);
  const [minThreshold, setMinThreshold] = useState(50);
  const [minPopulationScore, setMinPopulationScore] = useState(75);
  const [maxPopDiff, setMaxPopDiff] = useState();
  const [maxEffGap, setMaxEffGap] = useState(0.5);
  const [minPolsbyPopper, setMinPolsbyPopper] = useState(0.5);
  const [numIterations, setNumIterations] = useState(10);
  const [isLoading, setIsLoading] = useState(false);
  const [timeRunning, setTimeRunning] = useState(0);

  useEffect(() => {
    let interval = null;
    let checkInterval = null;
    if (algorithmRunning) {
      interval = setInterval(() => {
        setTimeRunning((time) => time + 10);
      }, 10);
      checkInterval = setInterval(() => {
        checkStatus();
      }, 5000);
    } else {
      clearInterval(interval);
      clearInterval(checkInterval);
    }
    return () => {
      clearInterval(interval);
      clearInterval(checkInterval);
    };
  }, [algorithmRunning]);

  function handleRun() {
    onRun(minOpportunity, maxOpportunity, maxPopDiff);
  }

  const Timer = ({ time }) => {
    return (
      <div className='timer'>
        <span>Time Running: </span>
        <span className='digits'>
          {('0' + Math.floor((time / 60000) % 60)).slice(-2)}:
        </span>
        <span className='digits'>
          {('0' + Math.floor((time / 1000) % 60)).slice(-2)}.
        </span>
        <span className='digits mili-sec'>
          {('0' + ((time / 10) % 100)).slice(-2)}
        </span>
      </div>
    );
  };

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
          value={maxPopDiff}
          onChange={(event) => {
            setMaxPopDiff(event.target.value);
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
        {!algorithmRunning ? (
          <Button
            isLoading={algorithmRunning}
            colorScheme='blue'
            size='lg'
            onClick={handleRun}
          >
            Run Algorithm
          </Button>
        ) : (
          <Button colorScheme='red' size='lg' onClick={onStop}>
            Stop Algorithm
          </Button>
        )}
      </div>
      {algorithmStarted ? (
        <div>
          <Timer time={timeRunning} />
          <Progress size='xs' isIndeterminate={algorithmRunning} />
          {algorithmSummary ? (
            <div>Number of Iterations: {algorithmSummary.numIterations}</div>
          ) : null}
        </div>
      ) : null}
    </>
  );
};

export default RunAlgorithm;
