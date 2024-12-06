package fr.istic.vv;

class Date implements Comparable<Date> {

	int day;
	int month;
	int year;

    public Date(int day, int month, int year) { 
    	this.day=day;
    	this.month=month;
    	this.year=year;
    }

    public static boolean isValidDate(int day, int month, int year) { 
    	if (month < 1 || month > 12 || day < 1 || year < 1) {
            return false;
        }

        int[] JoursParMois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        //cas année bissexitle
        if (isLeapYear(year)) {
        	JoursParMois[1] = 29;
        }

        return day <= JoursParMois[month - 1];

    }

    public static boolean isLeapYear(int year) { 
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public Date nextDate() { 
    	int[] JoursParMois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    if (isLeapYear(this.year)) {
	        JoursParMois[1] = 29;
	    }
	
	    int nextDay = this.day + 1;
	    int nextMonth = this.month;
	    int nextYear = this.year;
	
	    if (nextDay > JoursParMois[this.month - 1]) {
	        nextDay = 1;
	        nextMonth++;
	    }
	
	    if (nextMonth > 12) {
	        nextMonth = 1;
	        nextYear++;
	    }
	
	    return new Date(nextDay, nextMonth, nextYear); 
    
    }
	
    public Date previousDate() {
    	
    	int[] JoursParMois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(this.year)) {
            JoursParMois[1] = 29;
        }

        int prevDay = this.day - 1;
        int prevMonth = this.month;
        int prevYear = this.year;

        if (prevDay < 1) {
            prevMonth--;
            if (prevMonth < 1) {
                prevMonth = 12;
                prevYear--;
            }
            prevDay = JoursParMois[prevMonth - 1];
        }

        return new Date(prevDay, prevMonth, prevYear);
    }

    public int compareTo(Date other) { 
    	
    	if (other == null) {
            throw new NullPointerException("La date de comparaison est null");
        }
        if (this.year != other.year) {
            return this.year - other.year;
        }
        if (this.month != other.month) {
            return this.month - other.month;
        }
        return this.day - other.day;
    }
    
    //methode ajouter pour les tests
    
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", this.day, this.month, this.year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Date date = (Date) obj;
        return day == date.day && month == date.month && year == date.year;
    }

}