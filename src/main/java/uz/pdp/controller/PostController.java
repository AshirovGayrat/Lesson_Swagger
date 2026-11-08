package uz.pdp.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.PostFilterDTO;
import uz.pdp.entity.Post;
import uz.pdp.exceptions.EntityNotFoundException;
import uz.pdp.repo.PostRepository;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Tag(name = "Post Controller", description = "Post Controller class ichida post bilan CRUD amallar bajariladi")
public class PostController {

    private final PostRepository postRepository;

    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @GetMapping("/{id}")
    @Operation(summary = "Post by id", description = "Bu API id orqali postni qaytaradi")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marxamat post ni koring", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Post.class))
            })
            ,
            @ApiResponse(responseCode = "404", description = "Post Not found", content = {
                    @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = EntityNotFoundException.class))
            })
    })
    public ResponseEntity<Post> getPost(@PathVariable Integer id) {
        Post comment = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post Not Found With ID: " + id));
        return ResponseEntity.ok(comment);
    }




    @GetMapping("/")
    public ResponseEntity<List<Post>> getAllPost(@RequestBody PostFilterDTO dto) {
        System.out.println( dto );
        List<Post> comments = postRepository.findAll();
        return ResponseEntity.ok(comments);
    }




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Post Not Found With ID: " + id));
        postRepository.deleteById(post.getId());
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/")
    public ResponseEntity<Post> savePost(@RequestBody Post comment) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(comment));
    }
}
