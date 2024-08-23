/*
 * nnevolko
 */

public class ScoreTriplet {

	private int clarity;
	private int originality;
	private int difficulty;

	public ScoreTriplet(int clarity, int originality, int difficulty) {
		super();
		this.clarity = clarity;
		this.originality = originality;
		this.difficulty = difficulty;
	}

	public int getClarity() {
		return clarity;
	}

	public void setClarity(int clarity) {
		this.clarity = clarity;
	}

	public int getOriginality() {
		return originality;
	}

	public void setOriginality(int originality) {
		this.originality = originality;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public void compareScores(ScoreTriplet a, ScoreTriplet b) {

		int resultA = 0;
		int resultB = 0;
		if (a.getClarity() > b.getClarity()) {
			resultA++;
		} else if (b.getClarity() > a.getClarity()) {
			resultB++;
		}

		if (a.getDifficulty() > b.getDifficulty()) {
			resultA++;
		} else if (b.getDifficulty() > a.getDifficulty()) {
			resultB++;
		}

		if (a.getOriginality() > b.getOriginality()) {
			resultA++;
		} else if (b.getOriginality() > a.getOriginality()) {
			resultB++;
		}

		System.out.println(resultA + " " + resultB);

	}

}
