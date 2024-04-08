if (this.monnaie.equals(destination.getMonnaie()) && this.montant >= montantJetons) {
    this.montant -= montantJetons;
    destination.montant += montantJetons;
    return true;
}
return false;
}

ve