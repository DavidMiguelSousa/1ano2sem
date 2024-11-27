package pt.ipp.isep.dei.esoft.project.domain;

public enum Role {
    STORE_MANAGER("store_manager"),
    STORE_NETWORK_MANAGER("store_network_manager"),
    AGENT("agent");

    String value;

    Role(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
