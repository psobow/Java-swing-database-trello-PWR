package ocado;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class AlgorithmAPITest {

    @Test
    public void firstTest(){

        AlgorithmAPI obj = new AlgorithmAPI();
        obj.fetchData();
        Long[] ID = {1L,2L,3L};
        obj.packProductsIntoBags(Arrays.asList(ID));
        obj.printResults();

    }

}