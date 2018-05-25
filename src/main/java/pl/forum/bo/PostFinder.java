package pl.forum.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.forum.repository.PostRepository;

@Service
public class PostFinder {

    private PostRepository postRepository;

    @Autowired
    public PostFinder(PostRepository postRepository) {
        this.postRepository = postRepository;
    }



}
