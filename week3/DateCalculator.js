const DateOperation = require('./DateOperation')

module.exports = class DateCalculator{
    constructor(inputDate){
        this.inputDate = new DateOperation(inputDate)
    }
    
    operations(operation, value){
        switch (operation) {
            case 'today':
                return this.inputDate.getCurrentDate()
                break;
            case 'tomorrow':
                return this.inputDate.addDay(1)
                break;
            case 'day-after-tomorrow':
                return this.inputDate.addDay(2)
                break;
            case 'yesterday':
                return this.inputDate.subtractDay(1)
                break;
            case 'day-before-yesterday':
                return this.inputDate.subtractDay(2)
                break;
            case 'next-week':
                return this.inputDate.addWeek(1)
                break;
            case 'last-week':
                return this.inputDate.subtractWeek(1)
                break;
            case 'next-month':
                return this.inputDate.addMonth(1)
                break;
            case 'last-month':
                return this.inputDate.subtractMonth(1)
                break;
            case 'next-year':
                return this.inputDate.addYear(1)
                break;
            case 'last-year':
                return this.inputDate.subtractYear(1)
                break;
            case 'days-from-now':
                return this.inputDate.addDay(Number(value))
                break;
            case 'days-earlier':
                return this.inputDate.subtractDay(Number(value))
                break;
            case 'months-from-now':
                return this.inputDate.addMonth(Number(value))
                break;
            case 'months-earlier':
                return this.inputDate.subtractMonth(Number(value))
                break;
            case 'years-from-now':
                return this.inputDate.addYear(Number(value))
                break;
            case 'years-earlier':
                return this.inputDate.subtractYear(Number(value))
                break;
            default:
                break;
        }
    }
}



