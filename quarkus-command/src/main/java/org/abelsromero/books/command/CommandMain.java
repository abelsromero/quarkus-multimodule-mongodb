package org.abelsromero.books.command;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import io.vertx.mutiny.core.Vertx;
import lombok.extern.slf4j.Slf4j;
import org.abelsromero.books.command.local.LocalBooksRepository;

import javax.inject.Inject;

@Slf4j
@QuarkusMain
public class CommandMain implements QuarkusApplication {

    @Inject
    BooksRepository repository;

    @Inject
    LocalBooksRepository localRepository;

    @Inject
    Vertx vertx;

    public int run(String... args) {
        logger.info("Starting...");

//        final DataInitializer dataInitializer = new DataInitializer(repository);
//        timed(() -> dataInitializer.initDataWithArray(10));
//
        try {
            repository.findAll()
                .forEach(System.out::println);
        } catch (Throwable e) {
            logger.error("Error retrieving books", e);
        }

        try {
            localRepository.findAll()
                .forEach(System.out::println);
        } catch (Throwable e) {
            logger.error("Error retrieving localRepository", e);
        }

//        Quarkus.waitForExit();
        return 0;
    }

    private void timed(Runnable runnable) {
        long init = System.currentTimeMillis();
        runnable.run();
        logger.info("time: {}", System.currentTimeMillis() - init);
    }

}
