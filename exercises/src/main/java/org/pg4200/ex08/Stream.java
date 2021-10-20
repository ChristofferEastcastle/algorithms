package org.pg4200.ex08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Stream {
    public <T, C extends Iterable<T>> AnotherStream<T> createStream(C collection) {
        return new Pipeline<T, T, T>(collection.iterator());
    }

    protected static abstract class ChainedReference<IN, OUT> implements Consumer<IN> {

        protected final Consumer<OUT> downstream;

        public ChainedReference(Consumer<OUT> downstream) {
            this.downstream = Objects.requireNonNull(downstream);
        }
    }

    private class Pipeline<IN, OUT, T> implements AnotherStream<OUT> {
        private final Iterator<T> iterator;
        private final Pipeline<?, IN, T> previousStage;
        private final int depth;

        public Pipeline(Iterator<T> iterator) {
            this.iterator = iterator;
            this.previousStage = null;
            this.depth = 0;
        }

        public Pipeline(Pipeline section) {
            this.iterator = section.iterator;
            this.previousStage = section;
            this.depth = section.depth + 1;
        }

        private Consumer<T> chainAllConsumersInThePipeline(Consumer<OUT> consumer) {
            Objects.requireNonNull(consumer);

            Pipeline p = this;

            while (p.depth > 0) {
                consumer = p.chainConsumerToCurrentPipe(consumer);
                p = p.previousStage;
            }

            return (Consumer<T>) consumer;
        }

        private Consumer<OUT> chainConsumerToCurrentPipe(Consumer<OUT> consumer) {
            throw new IllegalStateException();
        }

        @Override
        public int count() {
            int[] count = {0};

            var collectingConsumer = new Consumer<OUT>() {
                @Override
                public void accept(OUT out) {
                    count[0]++;
                }
            };

            Consumer<T> chain = chainAllConsumersInThePipeline(collectingConsumer);

            while (iterator.hasNext()) {
                T element = iterator.next();
                chain.accept(element);
            }
            return count[0];
        }


        @Override
        public String joinToString(String separator) {
            return null;
        }

        @Override
        public boolean any(Predicate<OUT> predicate) {
            return false;
        }

        @Override
        public Optional<OUT> reduce(BinaryOperator<OUT> accumulator) {
            return Optional.empty();
        }

        @Override
        public AnotherStream<OUT> distinct() {

            AnotherStreamList<OUT> list = new AnotherStreamList<>();

            var collectingConsumer = new Consumer<OUT>() {
                @Override
                public void accept(OUT out) {
                    if (!list.contains(out)) list.add(out);
                }
            };

            Consumer<T> chain = chainAllConsumersInThePipeline(collectingConsumer);

            while (iterator.hasNext()) {
                T element = iterator.next();
                chain.accept(element);
            }

            return list.stream();
        }

        @Override
        public AnotherStream<OUT> skip(int n) {
            int[] counter = {n};
            AnotherStreamList<OUT> list = new AnotherStreamList<>();


            var collectingConsumer = new Consumer<OUT>() {
                @Override
                public void accept(OUT out) {
                    list.add(out);
                }
            };

            Consumer<T> chain = chainAllConsumersInThePipeline(collectingConsumer);

            while (iterator.hasNext()) {
                T element = iterator.next();
                if (counter[0]-- > 0) continue;

                chain.accept(element);
            }

            return list.stream();
        }

        @Override
        public AnotherStream<OUT> sorted() {
            return null;
        }
    }
}
