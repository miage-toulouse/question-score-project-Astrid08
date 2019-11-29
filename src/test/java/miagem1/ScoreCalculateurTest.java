package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private ScoreCalculateur score;
    private QuestionAChoixMultiple questionAChoixMultiple;

    @Before
    public void setUp() throws Exception {
        // given : une instance de ScoreCalculateur et Question à choix multiple
        score = new ScoreCalculateur();
        questionAChoixMultiple = new QuestionAChoixMultiple("q1",new ArrayList<Integer>(Arrays.asList(2,3,5)), 5);
    }

    @Test
    public void testCalculeScoreMauvaisesReponses() {
        // when : quand l'étudiant fourni l'indice des mauvaises réponses

        List<Integer> listeReponsesEtudiant = new ArrayList<Integer>(Arrays.asList(1, 4));
        float resScore = 0;
        resScore = score.calculeScore(listeReponsesEtudiant, questionAChoixMultiple);
        // then : le score obtenu est 0
        assertEquals(0f, resScore, 0.01f);
    }

    @Test
    public void testCalculeScoreDeuxBonnesReponses() {
        // when : quand l'étudiant fourni l'indice de  2 bonnes réponses

        List<Integer> listeReponsesEtudiant = new ArrayList<Integer>(Arrays.asList(2, 3));
        float resScore = 0;
        resScore = score.calculeScore(listeReponsesEtudiant, questionAChoixMultiple);
        // then : le score obtenu est 2*100/3f
        assertEquals(2*100/3f, resScore, 0.01f);
    }

    @Test
    public void testCalculeScoreBonnesReponses() {
        // when : quand l'étudiant fourni l'indice de  toutes les bonnes réponses

        List<Integer> listeReponsesEtudiant = new ArrayList<Integer>(Arrays.asList(2, 3, 5));
        float resScore = 0;
        resScore = score.calculeScore(listeReponsesEtudiant, questionAChoixMultiple);
        // then : le score obtenu est 100
        assertEquals(100f, resScore, 0.01f);
    }

    @Test
    public void testCalculeScoreToutesReponsesPossibles() {
        // when : quand l'étudiant fourni l'indice de  toutes les réponses possibles

        List<Integer> listeReponsesEtudiant = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
        float resScore = 0;
        resScore = score.calculeScore(listeReponsesEtudiant, questionAChoixMultiple);
        // then : le score obtenu est 0
        assertEquals(0f, resScore, 0.01f);
    }

    @Test
    public void testCalculeScoreDeuxBonnesRepUneFausse() {
        // when : quand l'étudiant fourni l'indice de 2 bonnes réponses et d'une fausse

        List<Integer> listeReponsesEtudiant = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        float resScore = 0;
        resScore = score.calculeScore(listeReponsesEtudiant, questionAChoixMultiple);
        // then : le score obtenu est 16,66
        assertEquals(16.66f, resScore, 0.01f);
    }
}