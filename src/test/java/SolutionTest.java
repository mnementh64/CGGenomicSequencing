import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolutionTest {

    @Test
    public void mergeStrings_1() throws IOException {
        String s1 = "AT";
        String s2 = "TC";

        String merged = ProblemSolver.mergeStrings(s1, s2);

        Assert.assertEquals("C", merged);
    }

    @Test
    public void mergeStrings_2() throws IOException {
        String s1 = "ATR";
        String s2 = "TRC";

        String merged = ProblemSolver.mergeStrings(s1, s2);

        Assert.assertEquals("C", merged);
    }

    @Test
    public void mergeStrings_3() throws IOException {
        String s1 = "AGATTACA";
        String s2 = "TACAGA";

        String merged = ProblemSolver.mergeStrings(s1, s2);

        Assert.assertEquals("GA", merged);
    }

    @Test
    public void test_1() throws IOException {
        Problem problem = new Problem();
        problem.addSequence("AAC");
        problem.addSequence("CCTT");

        ProblemSolver solver = new ProblemSolver(problem);

        Assert.assertEquals(6, solver.solve());
    }

    @Test
    public void test_2() throws IOException {
        Problem problem = new Problem();
        problem.addSequence("AGATTA");
        problem.addSequence("GATTACA");
        problem.addSequence("TACAGA");

        ProblemSolver solver = new ProblemSolver(problem);

        Assert.assertEquals(10, solver.solve());
    }

    @Test
    public void test_3() throws IOException {
        Problem problem = new Problem();
        problem.addSequence("TT");
        problem.addSequence("AA");
        problem.addSequence("ACT");

        ProblemSolver solver = new ProblemSolver(problem);

        Assert.assertEquals(5, solver.solve());
    }

    @Test
    public void test_4() throws IOException {
        Problem problem = new Problem();
        problem.addSequence("AGATTA");
        problem.addSequence("GAT");

        ProblemSolver solver = new ProblemSolver(problem);

        Assert.assertEquals(6, solver.solve());
    }

    @Test
    public void test_5() throws IOException {
        Problem problem = new Problem();
        problem.addSequence("GAT");
        problem.addSequence("AGATTA");

        ProblemSolver solver = new ProblemSolver(problem);

        Assert.assertEquals(6, solver.solve());
    }

    @Test
    public void test_6() throws IOException {
        Problem problem = new Problem();
        problem.addSequence("AT");
        problem.addSequence("CG");

        ProblemSolver solver = new ProblemSolver(problem);

        Assert.assertEquals(4, solver.solve());
    }

    @Test
    public void test_7() throws IOException {
        Problem problem = new Problem();
        problem.addSequence("CCCTG");
        problem.addSequence("TGACA");
        problem.addSequence("CATGA");

        ProblemSolver solver = new ProblemSolver(problem);

        Assert.assertEquals(11, solver.solve());
    }


}