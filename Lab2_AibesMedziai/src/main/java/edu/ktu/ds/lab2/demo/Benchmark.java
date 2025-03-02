package edu.ktu.ds.lab2.demo;

import edu.ktu.ds.lab2.utils.AvlSet;
import edu.ktu.ds.lab2.utils.BstSet;
import edu.ktu.ds.lab2.utils.BstSetIterative;
import edu.ktu.ds.lab2.utils.SortedSet;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.BenchmarkParams;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@State(Scope.Benchmark)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(time = 1, timeUnit = TimeUnit.SECONDS, iterations = 2)
@Measurement(time = 1, timeUnit = TimeUnit.SECONDS)
public class Benchmark {

    @State(Scope.Benchmark)
    public static class FullSet {

        Car[] cars;
        BstSet<Car> carSet;
        AvlSet<Car> avlSet;

        @Setup(Level.Iteration)
        public void generateElements(BenchmarkParams params) {
            cars = Benchmark.generateElements(Integer.parseInt(params.getParam("elementCount")));
        }

        @Setup(Level.Invocation)
        public void fillCarSet(BenchmarkParams params) {
            carSet = new BstSet<>(Car.byPrice);
            avlSet = new AvlSet<>(Car.byPrice);
            addElements(cars, carSet);
            addElements(cars, avlSet);
        }
    }

    @Param({"1000", "2000", "5000", "10000"})
    public int elementCount;

    Car[] cars;
    BstSet<Car> carSet2;

    @Setup(Level.Iteration)
    public void generateElements() {
        cars = generateElements(elementCount);
        carSet2 = new BstSet<>(Car.byPrice);
        addElements(cars, carSet2);
    }

    static Car[] generateElements(int count) {
        return new CarsGenerator().generateShuffle(count, 1.0);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void addAllBstSet(FullSet fullSet) {
        fullSet.carSet.addAll(carSet2);
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void addAllAvlSet(FullSet fullSet) {
        fullSet.avlSet.addAll(carSet2);
    }

    /*
    @org.openjdk.jmh.annotations.Benchmark
    public BstSet<Car> addBstRecursive() {
        BstSet<Car> carSet = new BstSet<>(Car.byPrice);
        addElements(cars, carSet);
        return carSet;
    }

    @org.openjdk.jmh.annotations.Benchmark
    public BstSetIterative<Car> addBstIterative() {
        BstSetIterative<Car> carSet = new BstSetIterative<>(Car.byPrice);
        addElements(cars, carSet);
        return carSet;
    }

    @org.openjdk.jmh.annotations.Benchmark
    public AvlSet<Car> addAvlRecursive() {
        AvlSet<Car> carSet = new AvlSet<>(Car.byPrice);
        addElements(cars, carSet);
        return carSet;
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void removeBst(FullSet carSet) {
        for (Car car : carSet.cars) {
            carSet.carSet.remove(car);
        }
    }

    @org.openjdk.jmh.annotations.Benchmark
    public void sizeBst(FullSet carSet) {
        for (Car car : carSet.cars) {
            carSet.carSet.size();
        }
    }*/

    public static void addElements(Car[] carArray, SortedSet<Car> carSet) {
        for (Car car : carArray) {
            carSet.add(car);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(Benchmark.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
