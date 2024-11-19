public class EconomicData {
    private String state;
    private String Description;  // Changed to String
    private String personalIncome;  // Changed to String
    private String population;  // Changed to String
    private String perCapitaPersonalIncome;  // Changed to String

    public EconomicData(String state, String year, String personalIncome, String population, String perCapitaPersonalIncome) {
        this.state = state;
        this.Description = year;
        this.personalIncome = personalIncome;
        this.population = population;
        this.perCapitaPersonalIncome = perCapitaPersonalIncome;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public String getPersonalIncome() {
        return personalIncome;
    }

    public void setPersonalIncome(String personalIncome) {
        this.personalIncome = personalIncome;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getPerCapitaPersonalIncome() {
        return perCapitaPersonalIncome;
    }

    public void setPerCapitaPersonalIncome(String perCapitaPersonalIncome) {
        this.perCapitaPersonalIncome = perCapitaPersonalIncome;
    }
}

