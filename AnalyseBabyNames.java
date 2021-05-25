import org.apache.commons.csv.*;
import edu.duke.FileResource;
import java.io.File;
import java.util.*;
public class AnalyseBabyNames {
    public static void main(String args[]) {

        FindResults f=new FindResults();
        FileResource fr = new FileResource("yob2014short.csv");
        f.totalBirths(fr);

        int rank=f.getRank(2014,"Mason","M");
        System.out.println("Rank: "+rank);

        String name=getName();

        System.out.println("Sum of x+y = " + z);*/
    }
}
class FindResults{
    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int totalGirls = 0;
        int totalBoys = 0;
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser) {
            int numBorn = Integer.parseInt(record.get(2));
            String gender = record.get(1);
            totalBirths += numBorn;
            if(gender.equals("M")) {
                totalBoys += numBorn;
            } else {
                totalGirls += numBorn;
            }
        }
        System.out.println("Total: " + totalBirths);
        System.out.println("Boys: " + totalBoys);
        System.out.println("Girls: " + totalGirls);
    }
    public int getRank(int year, String name, String gender) {
        int rank = -1;
        FileResource fr = new FileResource("us_babynames/us_babynames_test/yob" + year + "short.csv");
        CSVParser parser = fr.getCSVParser(false);

        for(CSVRecord record : parser) {
            String currName = record.get(0);
            String currGender = record.get(1);

            if(currGender.equals(gender) && currName.equals(name)) {
                rank = record.getRecordNumber();
            }
        }
        return rank;
    }
    public String getName(int year, int rank, String gender) {
        String name = "";
        FileResource fr = new FileResource("us_babynames/us_babynames_test/yob" + year + "short.csv");
        CSVParser parser = fr.getCSVParser(false);

        for(CSVRecord record : parser) {
            long currRank = record.getRecordNumber();
            String currGender = record.get(1);
            String currName = record.get(0);

            if(currRank == rank && currGender.equals(gender)) {
                name = currName;
            }
        }

        if(name != "") {
            return name;
        }
        else {
            return "NO NAME";
        }
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        FileResource fr = new FileResource("us_babynames/us_babynames_test/yob" + year + "short.csv");
        FileResource newFr = new FileResource("us_babynames/us_babynames_test/yob" + newYear + "short.csv");
        CSVParser parserOld = fr.getCSVParser(false);
        CSVParser parserNew = newFr.getCSVParser(false);
        String newName = "";
        long popularity = 0;

        for(CSVRecord record : parserOld) {
            String currName = record.get(0);
            String currGender = record.get(1);

            if(currName.equals(name) && currGender.equals(gender)) {
                popularity = record.getRecordNumber();
            }
        }

        for(CSVRecord record : parserNew) {
            String currGender = record.get(1);
            long currPopularity = record.getRecordNumber();

            if(currGender.equals(gender) && popularity == currPopularity) {
                newName = record.get(0);
            }
        }

        System.out.println(name + " born in " + year + " would be " + newName + " if she was born in " + newYear);
    }


     public int yearOfHighestRank(String name, String gender) {
        long highestRank = 0;
        int yearOfHighestRank = -1;
        String fileName = "";
        DirectoryResource dr = new DirectoryResource();


        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);


            for(CSVRecord record : parser) {
                String currName = record.get(0);
                String currGender = record.get(1);

                if(currName.equals(name) && currGender.equals(gender)) {
                    long currRank = record.getRecordNumber();

                    if(highestRank == 0) {
                        highestRank = currRank;
                        fileName = f.getName();
                    }
                    else {
                        if(highestRank > currRank) {
                            highestRank = currRank;
                            fileName = f.getName();
                        }
                    }
                }
            }
        }


        fileName = fileName.replaceAll("[^\\d]", "");


        yearOfHighestRank = Integer.parseInt(fileName);

        return yearOfHighestRank;
    }


    public double getAverageRank(String name, String gender) {
        // Initialize a DirectoryResource
        DirectoryResource dr = new DirectoryResource();
        // Define rankTotal, howMany
        double rankTotal = 0.0;
        int howMany = 0;
        // For every file the directory add name rank to agvRank
        for(File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser parser = fr.getCSVParser(false);
            for(CSVRecord record : parser) {
                String currName = record.get(0);
                String currGender = record.get(1);
                if(currName.equals(name) && currGender.equals(gender)){
                    long currRank = record.getRecordNumber();
                    rankTotal += (double)currRank;
                    howMany += 1;
                }
            }
        }

        double avgRank = rankTotal / (double)howMany;
        return avgRank;
    }


    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        int numBorn = 0;
        long rank = getRank(year, name, gender);
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser(false);
        for(CSVRecord record : parser) {
            int currBorn = Integer.parseInt(record.get(2));
            String currGender = record.get(1);
            long currRank = record.getRecordNumber();
            if(gender.equals(currGender) && rank > currRank) {
                numBorn += currBorn;
            }
        }
        return numBorn;
    }

}
