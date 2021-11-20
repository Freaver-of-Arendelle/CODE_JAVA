package solid.LawOfDemeter;

/**
 * @author Freaver
 * @date 4/27/2021 19:27
 */
public class Client {
    public static void main(String[] args) {
        Agent agent = new Agent();

        Star star = new Star("Lin");

        agent.setStar(star);

        Fans fans = new Fans("si");

        agent.setFans(fans);

        Company company = new Company("Helma");

        agent.setCompany(company);

        agent.meeting();
        agent.business();


    }
}
