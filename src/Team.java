import java.util.ArrayList;


public class Team {

	ArrayList<Player> players = new ArrayList();
	protected String yearMin;
	protected String gamesPlayed;
	protected String wins;
	protected String losses;
	protected String winLossPct;
	protected String yearsPlayoffs;
	protected String yearsDivChamps;
	protected String conferenceChamps;
	protected String leagueChamps;
	
	
	Team(ArrayList<Player>player, String yearMin, String gamesPlayed, String wins, String losses, String winLossPct, String yearsPlayoffs, 
			String yearsDivChamps, String conferenceChamps, String leagueChamps){
		this.players = player;
		this.yearMin = yearMin;
		this.gamesPlayed = gamesPlayed;
		this.wins = wins;
		this.losses = losses;
		this.winLossPct = winLossPct;
		this.yearsPlayoffs = yearsPlayoffs;
		this.yearsDivChamps = yearsDivChamps;
		this.conferenceChamps = conferenceChamps;
		this.leagueChamps = leagueChamps;
	}
	
	public ArrayList<Player> getPlayers() {
		return players;
	}

	public String getYearMin() {
		return yearMin;
	}

	public String getGamesPlayed() {
		return gamesPlayed;
	}

	public String getWins() {
		return wins;
	}

	public String getLosses() {
		return losses;
	}

	public String getWinLossPct() {
		return winLossPct;
	}

	public String getYearsPlayoffs() {
		return yearsPlayoffs;
	}

	public String getYearsDivChamps() {
		return yearsDivChamps;
	}

	public String getConferenceChamps() {
		return conferenceChamps;
	}

	public String getLeagueChamps() {
		return leagueChamps;
	}

	
	
}
