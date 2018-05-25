package pl.forum.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.forum.entity.Thread;
import pl.forum.repository.ThreadRepository;

import java.util.List;

@Service
public class ThreadFinder {

    private ThreadRepository threadRepository;

    @Autowired
    public ThreadFinder(ThreadRepository threadRepository) {
        this.threadRepository = threadRepository;
    }

    public List<Thread> findAllThreads() {

        threadRepository.save(Thread.builder()
                .name("thread1")
                .build());
        threadRepository.save(Thread.builder()
                .name("thread2")
                .build());
        threadRepository.save(Thread.builder()
                .name("thread3")
                .build());
        threadRepository.save(Thread.builder()
                .name("thread4")
                .build());
        threadRepository.save(Thread.builder()
                .name("thread5")
                .build());

        return threadRepository.findAll();
    }

}
