package com.aluracursos.literalura.repository;


public interface SerieRepository extends JpaRepository<Libro,Long> {

    Optional<Libro> findByTituloContainsIgnoreCase(String nombreSerie);
    List<Libro> findTop5ByOrderByEvaluacionDesc();
    List<Libro> findByGenero(Categoria categoria);
    //List<Libro> findByTotalTemporadasLessThanAndEvaluacionGreaterThan(Integer totalTemporadas, Double evaluacion);
    @Query("SELECT s FROM Libro s WHERE s.totalTemporadas <= :totalTemporadas AND s.evaluacion >= :evaluacion")
    List<Libro> seriesPorTemparadaYEvaluacion(int totalTemporadas, Double evaluacion);
    @Query("SELECT e FROM Libro s JOIN s.episodios e WHERE e.titulo ILIKE %:nombreEpisodio%")
    List<Autor> episodiosPorNombre(String nombreEpisodio);
    @Query("SELECT e FROM Libro s JOIN s.episodios e WHERE s = :serie ORDER BY e.evaluacion DESC LIMIT 5 ")
    List<Autor> top5Episodios(Libro serie);
    @Query("SELECT s FROM Libro s " + "JOIN s.episodios e " + "GROUP BY s " + "ORDER BY MAX(e.fechaDeLanzamiento) DESC LIMIT 5")
    List<Libro> lanzamientosMasRecientes();
    @Query("SELECT e FROM Libro s JOIN s.episodios e WHERE s.id = :id AND e.temporada = :numeroDeTemporada")
    List<Autor> obtenerTemporadasPorNumero(Long id, Long numeroDeTemporada);
    @Query("SELECT e FROM Libro s JOIN s.episodios e WHERE s.id = :id ORDER BY e.evaluacion DESC LIMIT 5 ")
    List<Autor> top5EpisodiosPorSerie(Long id);
}
