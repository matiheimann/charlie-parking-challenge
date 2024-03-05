package assessment.parkinglot.dto;

public class AllSpacesTakenDTO {
    private boolean allSpacesTaken;

    public AllSpacesTakenDTO(boolean allSpacesTaken) {
        this.allSpacesTaken = allSpacesTaken;
    }

    public boolean getAllSpacesTaken() {
        return this.allSpacesTaken;
    }
}
