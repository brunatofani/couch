import com.couch.friendship.entity.Relationship
import com.couch.friendship.repository.RelationshipRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
class RelationshipController (val repository: RelationshipRepository) {

    @GetMapping("/relationship")
    fun all(): MutableList<Relationship?> {
        return repository.findAll()
    }


    @GetMapping("/relationship/{id}")
    fun one(@PathVariable id: Long?): Relationship? {
        return id?.let {
            repository.findById(it)
                .orElseThrow  { RuntimeException() }
        }
    }

    @PostMapping("/relationship")
    fun newRelationship(@RequestBody newRelationship: Relationship): Relationship? {
        return repository.save(newRelationship)
    }

    @DeleteMapping("/relationship/{id}")
    fun deleteEmployee(@PathVariable id: Long): ResponseEntity<*> {
        repository.deleteById(id)
        return ResponseEntity.noContent().build<Any>()
    }
}