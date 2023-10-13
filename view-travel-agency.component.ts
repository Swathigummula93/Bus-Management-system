import { Component } from '@angular/core';
import { TravelAgency } from '../travel-agency';
import { ActivatedRoute } from '@angular/router';
import { TravelAgencyServiceService } from '../travel-agency-service.service';

@Component({
  selector: 'app-view-travel-agency',
  templateUrl: './view-travel-agency.component.html',
  styleUrls: ['./view-travel-agency.component.css']
})
export class ViewTravelAgencyComponent {
  
  agencyId: number = 0;
  particularTravelAgency: TravelAgency = new TravelAgency();
  router: any;
 
  constructor(private route: ActivatedRoute, private travelAgencyService: TravelAgencyServiceService) { }

  ngOnInit(): void {
  
    this.agencyId = this.route.snapshot.params['agencyId'];  

    this.travelAgencyService.getTravelAgencyById(this.agencyId).subscribe( data => {
      this.particularTravelAgency = data;
      console.log( this.particularTravelAgency);
    });
  }
  goBack():any{
    this.router.navigate(['see-all-agencyDetails'])
  }
}
