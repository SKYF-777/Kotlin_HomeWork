package corparation

fun main() {
    val repository = WorkerRepository
    val workers = repository.workers
    for (worker in workers) {
        worker.work()
    }
}