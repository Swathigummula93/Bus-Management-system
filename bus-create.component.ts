import { Component } from '@angular/core';
import { Bus } from '../bus';
import { TravelAgency } from '../travel-agency';
import { ActivatedRoute, Router } from '@angular/router';
import { BusServiceService } from '../bus-service.service';
import { TravelAgencyServiceService } from '../travel-agency-service.service';

@Component({
  selector: 'app-bus-create',
  templateUrl: './bus-create.component.html',
  styleUrls: ['./bus-create.component.css']
})
export class BusCreateComponent {
 
  bus : Bus = new Bus();
  selectedTravelsIds:number[]=[];
  j: number=0;
  travelAgency:TravelAgency[]=[];  
selectedagencyIds: any;
  

  constructor(private busService: BusServiceService,private route: ActivatedRoute,
    private router: Router,private agencyService: TravelAgencyServiceService) { }

    
 ngOnInit():void{
  this.agencyService.getTravelAgencyList().subscribe((data: any) => {
  this.travelAgency = data;
   console.log(this.travelAgency);
  })
 }

    saveBus(agencyId:number){
      this.busService.createBus(this.bus,agencyId).subscribe( data =>{
        console.log(data);
        this.goToBusData();
      },
      error => console.log(error));
    }

    goToBusData(){
      this.router.navigate(['/buses']);
    }
    
    
  }

