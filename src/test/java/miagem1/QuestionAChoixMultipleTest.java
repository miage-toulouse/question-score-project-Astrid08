package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple question;

    @Before
    public void setUp() throws Exception {
        // given : une instance de question à choix multiple (liste d'entiers)

        List<Integer> listeReponses = new ArrayList<Integer>();
        listeReponses.add(1);
        listeReponses.add(2);
        question = new QuestionAChoixMultiple("un énoncé", listeReponses, 5);

    }

    @Test
    public void testGetEnonce() {
        // when : on demande l'énoncé à la question
        String resEnonce = question.getEnonce();

        // then : l'énoncé retourné est l'énoncé fourni à la construction de la question
        assertEquals("un énoncé", resEnonce);
    }

    @Test
    public void testGetScoreForIndice() {
        // when : quand l'étudiant fourni l'indice de la ou les bonne(s) réponse(s)

        List<Integer> listeReponsesEtudiant = new ArrayList<Integer>();
        listeReponsesEtudiant.add(2);
        listeReponsesEtudiant.add(1);
        float resScore = 0;
        for (int indiceEtudiant : listeReponsesEtudiant) {
            // and : on demande le score de l'indice à la question
            resScore = resScore + question.getScoreForIndice(indiceEtudiant);
        }
        // then : le score obtenu est 100
        assertEquals(100f, resScore, 0.01f);
    }

    @Test
    public void testGetScoreForIndiceMauvaiseRep() {

        // when : quand l'étudiant fourni l'indice de la ou les bonne(s) réponse(s)

        List<Integer> listeReponsesEtudiant = new ArrayList<Integer>();
        listeReponsesEtudiant.add(2);
        listeReponsesEtudiant.add(4);
        float resScore = 0;
        for (int indiceEtudiant : listeReponsesEtudiant) {
            resScore = resScore + question.getScoreForIndice(indiceEtudiant);
        }
        // then : le score obtenu est 16.66
        assertEquals(16.66f, resScore, 0.01f);

    }
}