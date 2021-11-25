import {
  Box,
  Flex,
  Heading,
  Select,
  Stack,
  Button,
  useColorModeValue,
  useBreakpointValue,
} from '@chakra-ui/react';
import StateSelect from '../StatesSelect';

const Navbar = ({
  map,
  selectedState,
  popMeasure,
  setPopMeasure,
  onReset,
  onSelect,
}) => {
  return (
    <Box h='9vh'>
      <Flex
        bg={useColorModeValue('white', 'gray.800')}
        color={useColorModeValue('gray.600', 'white')}
        minH={'60px'}
        py={{ base: 2 }}
        px={{ base: 4 }}
        borderBottom={1}
        borderStyle={'solid'}
        borderColor={useColorModeValue('gray.200', 'gray.900')}
        align={'center'}
      >
        <Flex flex={1} justify={{ base: 'center', md: 'start' }}>
          <Heading
            textAlign={useBreakpointValue({ base: 'center', md: 'left' })}
            fontFamily={'heading'}
            color={useColorModeValue('gray.800', 'white')}
          >
            Randistrictr
          </Heading>

          <Flex display={{ base: 'none', md: 'flex' }} ml={10}>
            <DesktopNav map={map} />
          </Flex>
        </Flex>

        <Box flex={1}>
          {map ? (
            <div
              style={{
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center',
              }}
            >
              <Button onClick={onReset}>Reset All</Button>
            </div>
          ) : null}
        </Box>

        <Stack flex={1} justify={'flex-end'} direction={'row'} spacing={6}>
          {/* <Button
            as={'a'}
            fontSize={'sm'}
            fontWeight={400}
            variant={'link'}
            href={'#'}
          >
            Sign In
          </Button>
          <Button
            display={{ base: 'none', md: 'inline-flex' }}
            fontSize={'sm'}
            fontWeight={600}
            color={'white'}
            bg={'pink.400'}
            href={'#'}
            _hover={{
              bg: 'pink.300',
            }}
          >
            Sign Up
          </Button> */}
          <Select
            defaultValue={popMeasure}
            onChange={(e) => setPopMeasure(e.target.value)}
          >
            <option value='TOTAL'>Total</option>
            <option value='VAP'>VAP</option>
            <option value='CVAP'>CVAP</option>
          </Select>
          <StateSelect
            map={map}
            selectedState={selectedState}
            onSelect={(state) => onSelect(state)}
          />
        </Stack>
      </Flex>
    </Box>
  );
};

const DesktopNav = ({ map }) => {
  return (
    <Stack direction={'row'} spacing={4}>
      <Box>{/* <StateSelect map={map} /> */}</Box>
    </Stack>
  );
};

export default Navbar;
