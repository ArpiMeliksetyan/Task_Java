package Task_5.service.implementation;

import Task_5.model.marketing.MarketingSpecialist;
import Task_5.model.marketing.SEO;
import Task_5.model.marketing.SMM;
import Task_5.service.MarketingService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class MarketingServiceImpl implements MarketingService {

    public void printInfo(MarketingSpecialist marketingSpecialist) {

        String[] name = marketingSpecialist.getClass().getName().split("\\.");

        if (name[name.length - 1].equals("SEO")) {
            printInfoSEO((SEO) marketingSpecialist);

        } else {
            printInfoSMM((SMM) marketingSpecialist);
        }
    }

    private void printInfoSEO(SEO seo) {

        System.out.println(
                "hours=" + seo.getHours() +
                        ", experience=" + seo.getExperience() +
                        ", per_Salary=" + seo.getPer_Salary() +
                        ", isCertifed=" + seo.isCertifed() +
                        ", isFullTime=" + seo.isFullTime() +
                        ", id=" + seo.getId() +
                        ", firtsName=" + seo.getFirtsName() +
                        ", LastName=" + seo.getLastName() +
                        ", departmentName=" + seo.getDepartmentName() +
                        ", position=" + seo.getPosition() +
                        ", tools=" + seo.getTools());


    }

    private String infoSEO(SEO seo) {

        return seo.getId() + "," +
                seo.getHours() + "," +
                seo.getExperience() + "," +
                seo.getPer_Salary() + "," +
                seo.isCertifed() + "," +
                seo.isFullTime() + "," +
                seo.getFirtsName() + "," +
                seo.getLastName() + "," +
                seo.getDepartmentName() + "," +
                seo.getPosition() + "," +
                seo.getTools();


    }


    public String print(MarketingSpecialist marketingSpecialist) {
        String[] name = marketingSpecialist.getClass().getName().split("\\.");

        if (name[name.length - 1].equals("SEO")) {

            return infoSEO((SEO) marketingSpecialist);

        } else {
            return infoSMM((SMM) marketingSpecialist);
        }
    }


    private void printInfoSMM(SMM smm) {

        System.out.println(
                "hours=" + smm.getHours() +
                        ", experience=" + smm.getExperience() +
                        ", per_Salary=" + smm.getPer_Salary() +
                        ", isCertifed=" + smm.isCertifed() +
                        ", isFullTime=" + smm.isFullTime() +
                        ", id=" + smm.getId() +
                        ", firtsName=" + smm.getFirtsName() +
                        ", LastName=" + smm.getLastName() +
                        ", departmentName=" + smm.getDepartmentName() +
                        ", position=" + smm.getPosition() +
                        ", socialPlatform=" + smm.getSocialPlatform()
        );
    }

    private String infoSMM(SMM smm) {

        return smm.getId() + "," +
                smm.getHours() + "," +
                smm.getExperience() + "," +
                smm.getPer_Salary() + "," +
                smm.isCertifed() + "," +
                smm.isFullTime() + "," +
                smm.getFirtsName() + "," +
                smm.getLastName() + "," +
                smm.getDepartmentName() + "," +
                smm.getPosition() + "," +
                smm.getSocialPlatform();
    }

    public void printAll(MarketingSpecialist[] marketingSpecialists) {

        for (int i = 0; i < marketingSpecialists.length; i++) {
            printInfo(marketingSpecialists[i]);
        }
    }

    public void write(MarketingSpecialist[] marketingSpecialists) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        new FileOutputStream(path);
        for (int i = 0; i < marketingSpecialists.length; i++) {
            String s = print(marketingSpecialists[i]) + "\n";
            Files.write(Paths.get(path), s.getBytes(), StandardOpenOption.APPEND);
        }
    }

    public MarketingSpecialist[] read(String path) throws IOException {

        String[] data = Files.readAllLines(Paths.get(path)).toArray(new String[0]);
        MarketingSpecialist[] marketingSpecialists = new MarketingSpecialist[data.length];

        for (int i = 0; i < data.length; i++) {

            String[] s = data[i].split(",");

            if (s[8].equals("SEO department")) {
                marketingSpecialists[i] = new SEO(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Double.parseDouble(s[3]), Boolean.parseBoolean(s[4]), Boolean.parseBoolean(s[5]), s[6], s[7], s[8], s[9], s[10]);
            } else if (s[8].equals("SMM department")) {
                marketingSpecialists[i] = new SMM(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Double.parseDouble(s[3]), Boolean.parseBoolean(s[4]), Boolean.parseBoolean(s[5]), s[6], s[7], s[8], s[9], s[10]);
            }
        }
        return marketingSpecialists;

    }

    public void printAllSortedByFirstname(MarketingSpecialist[] marketingSpecialists) {
        MarketingSpecialist temp;

        for (int i = 0; i < marketingSpecialists.length; i++) {
            for (int j = i + 1; j < marketingSpecialists.length; j++) {
                if (marketingSpecialists[i].getFirtsName().compareTo(marketingSpecialists[j].getFirtsName()) > 0) {
                    temp = marketingSpecialists[i];
                    marketingSpecialists[i] = marketingSpecialists[j];
                    marketingSpecialists[j] = temp;
                }
            }
        }
        printAll(marketingSpecialists);
    }

    public void comission(MarketingSpecialist[] marketingSpecialists) {
        double comission;
        for (int i = 0; i < marketingSpecialists.length; i++) {
            if (marketingSpecialists[i].getPer_Salary() < 4000) {
                comission = marketingSpecialists[i].getPer_Salary() * 1.5 * 21;
            } else if (marketingSpecialists[i].getPer_Salary() >= 4000 && marketingSpecialists[i].getPer_Salary() <= 7000) {
                comission = marketingSpecialists[i].getPer_Salary() * 2 * 21;
            } else {
                comission = marketingSpecialists[i].getPer_Salary() * 3 * 21;
            }

            System.out.println(marketingSpecialists[i].getFirtsName() + " " + marketingSpecialists[i].getLastName() + " commision is: " + comission);
        }

    }

    public void minExperience(MarketingSpecialist[] marketingSpecialists) {
        MarketingSpecialist marketingSpecialist = marketingSpecialists[0];
        int min = marketingSpecialists[0].getExperience();
        for (int i = 0; i < marketingSpecialists.length; i++) {
            if (marketingSpecialists[i].getExperience() < min) {
                marketingSpecialist = marketingSpecialists[i];
            }
        }
        System.out.println(marketingSpecialist.getFirtsName() + " " + marketingSpecialist.getLastName() + " has less experience than others");
    }


}
