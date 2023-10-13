import { Component, OnInit } from '@angular/core';
import { Bus } from '../bus';
import { BusServiceService } from '../bus-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bus-list',
  templateUrl: './bus-list.component.html',
  styleUrls: ['./bus-list.component.css']
})
export class BusListComponent implements OnInit{
removeAllBuses() {
throw new Error('Method not implemented.');
}
  buses: Bus[] = [];
  agencyName : string = "";
  constructor(private busService: BusServiceService,
    private router: Router) { }

viewBus(bus_Id:number){
  this.router.navigate(['view-bus-details',bus_Id]);
  
}

  ngOnInit(): void {
    this.getbusDetails();
  }
  searchByAgencyName() : any{
    this.busService.searchByAgencyName(this.agencyName).subscribe(details => {
      this.buses= details;
      console.log(details);
    },
      error => {
        console.log(error);
      });
 }
 deleteBusById(bus_Id:number){
  var status =confirm("Are you sure? Do you want to delete?")
  if (status == true){
    this.busService.deleteBus(bus_Id).subscribe(data =>{
      this.getbusDetails();
    })
  }
 }
  deleteAllBusDetails() : void{
    var status = confirm("Are you sure to delete all the records?");
    if (status == true) {
      this.busService.deleteAll().subscribe(details => {
        console.log(details);
        this.getbusDetails();
      },
        error => {
          console.log(error);
        })
    }
    else{
    this.getbusDetails();
  }
  }
  getIsAcBus() {
    this.busService.findByIsACBus().subscribe({
      next: (res: Bus[]) => {
      console.log(res);
      this.buses = res;
    },
    error: (e: any) => console.error(e)
  });
  }

  getNonAcBus(){
    this.busService.findByNonACBus().subscribe({
      next: (res: Bus[]) => {
      console.log(res);
      this.buses = res;
    },
    error: (e) => console.error(e)
  });
  }
  private getbusDetails(): any{
    this.busService.getBusList().subscribe(data => {
      this.buses = data;
      console.log(data);
    });
  }

  busDetails(bus_Id: number){
    this.router.navigate(['getAllBuses', bus_Id]);
  }

  updateBus(bus_Id: number){
    this.router.navigate(['updatebus', bus_Id]);
  }

  
  
    getBusBySorting(option:string){
  
      switch(option){
        case "costlow":
          this.busService.sortCost("asc","ticket_Price").subscribe(data=>{
            this.buses=data;
            console.log(data);
          },error=>{console.log(error)}
          )
          break;
          case "costHigh":
          this.busService.sortCost("desc","ticket_Price").subscribe(data=>{
            this.buses=data;
            console.log(data)
          },error=>{console.log(error)}
          )
          break;
          case "ratinglow":
            this.busService.sortRating("asc","rating").subscribe(data=>{
              this.buses=data;
              console.log(data)
            },error=>{console.log(error)}
            )
            break;
            case "ratingHigh":
              this.busService.sortRating("desc","rating").subscribe(data=>{
                this.buses=data;
                console.log(data)
              },error=>{console.log(error)}
              )
    
      }
    }
    
  }


  
  


 