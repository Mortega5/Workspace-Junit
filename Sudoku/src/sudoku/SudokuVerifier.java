package sudoku;

public class SudokuVerifier {

	private String candidateSolution;

	public SudokuVerifier(String candidateSolution) {
		this.candidateSolution = candidateSolution;
	}

	public String getCandidateSolution() {
		return candidateSolution;
	}
	
	public boolean verifierSudoku() {
		boolean resolved = true;
		
		return resolved;
	}
}