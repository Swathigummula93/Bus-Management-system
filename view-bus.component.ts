import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Bus } from '../bus';
import { BusServiceService } from '../bus-service.service';

@Component({
  selector: 'app-view-bus',
  templateUrl: './view-bus.component.html',
  styleUrls: ['./view-bus.component.css']
})
export class ViewBusComponent {
  bus_Id: number = 0;
  particularBus: Bus = new Bus();
  particularTravelagency:any;
  
  constructor(private route: ActivatedRoute, private busService: BusServiceService,private router:Router) { }

  ngOnInit(): void {
    
    this.bus_Id = this.route.snapshot.params['bus_Id'];  //1


    this.busService.getBusById(this.bus_Id).subscribe( data => {
      this.particularBus = data;
      this.particularTravelagency=data.travelAgency;
      
      console.log( this.particularBus);
    });
  }
  
  goToBusData():any{
    this.router.navigate(['see-all-bus'])
  }
  goToTravelAgency():any{
    this.router.navigate(['view-travelAgency-details',this.particularTravelagency])
  }
}
