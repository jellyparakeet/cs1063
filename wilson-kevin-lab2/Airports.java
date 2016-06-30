// All coordinates were provided by the Great Circle Mapper
// http://www.gcmap.com/
public class Airports
{ 
  // Returns the airport's latitude given its three letter
  // IATA code in all capital letters
  public static double getAirportLatitude( String airport )
  {
    AirportCodes code = AirportCodes.valueOf( airport );
    switch( code )
    {
      case ATL:
        return 33.636700;
      case PEK:
        return 40.073;
      case DXB: 
        return 25.252778;
      case ORD: 
        return 41.977320;
      case HND: 
        return 35.553333;
      case LHR:
        return 51.477500;
      case LAX:
        return 33.942505;
      case HKG:
        return 22.308889; 
      case CDG: 
        return 49.009722;
      case DFW:
        return 32.897232;
      case IST: 
        return 40.976111;
      case FRA: 
        return 50.033306;
      case PVG: 
        return 31.145;
      case AMS: 
        return 52.308613;
      case JFK:
        return 40.639926;
      case SIN: 
        return 1.359211;
      case CAN: 
        return 23.393;
      case CGK:
        return -6.125566; 
      case DEN:
        return 39.861667; 
      case BKK:
        return 13.681108; 
      case SFO: 
        return 37.618806;
      case ICN: 
        return 37.469075;
      case KUL: 
        return 2.745578;
      case MAD: 
        return 40.493556;
      case DEL:
        return 28.568728;
      case SAT:
        return 29.533958;
      // LAT
      case LAS: 
        return 36.080056;
      case CLT: 
        return 35.213741;
      case MIA: 
        return 25.795361;
      case PHX: 
        return 33.434278;
      case IAH: 
        return 29.984444;
      case SEA:
        return 47.449889; 
      case CTU: 
        return 30.580;
      case YYZ: 
        return 43.677223;
      case MUC:
        return 48.353783; 
      case BOM: 
        return 19.088686;
      case FCO:
        return 41.804475; 
      case LGW:
        return 51.148056; 
      case SYD: 
        return -33.946110;
      // LAT
      case SZX: 
        return 22.638;
      case BCN: 
        return 41.297078;
      case GRU:
        return -23.432074; 
      case SHA:
        return 31.197; 
      case MCO:
        return 28.429389; 
      case TPE:
        return 25.077731; 
      case MEX:
        return 19.436303; 
      case KMG: 
        return 25.105;
      case EWR:
        return 40.692480; 
      case NRT:
        return 35.765278; 
      case MNL:
        return 14.508647; 
      case MSP:
        return 44.881972;
      default:
        return 0;
    }
  }
  
  // Returns the airport's longitude given its three letter
  // IATA code in all capital letters
  public static double getAirportLongitude( String airport )
  {
    AirportCodes code = AirportCodes.valueOf( airport );
    switch( code )
    {
      case ATL:
        return -84.427863;
      case PEK:
        return 116.598;
      case DXB: 
        return 55.364444;
      case ORD: 
        return -87.908005;
      case HND: 
        return 139.781111;
      case LHR:
        return -0.461388;
      case LAX:
        return -118.407112;
      case HKG:
        return 113.914722; 
      case CDG: 
        return 2.547778;
      case DFW:
        return -97.037694;
      case IST: 
        return 28.813889;
      case FRA: 
        return 8.570456;
      case PVG: 
        return 121.793;
      case AMS: 
        return 4.763889;
      case JFK:
        return -73.778694;
      case SIN: 
        return 103.989333;
      case CAN: 
        return 113.308;
      case CGK:
        return 106.655897; 
      case DEN:
        return -104.673166; 
      case BKK:
        return 100.747283; 
      case SFO: 
        return -122.375416;
      case ICN: 
        return 126.450517;
      case KUL: 
        return 101.709917;
      case MAD: 
        return -3.566763;
      case DEL:
        return 77.112136;
      case SAT: 
        return -98.469056;
      // LONG
      case LAS: 
        return -115.152249;
      case CLT: 
        return -80.949068;
      case MIA: 
        return -80.290110;
      case PHX: 
        return -112.011582;
      case IAH: 
        return -95.341443;
      case SEA:
        return -122.311777; 
      case CTU: 
        return 103.948;
      case YYZ: 
        return -79.630555;
      case MUC:
        return 11.786086; 
      case BOM: 
        return 72.867919;
      case FCO:
        return 12.250797; 
      case LGW:
        return -0.190277; 
      case SYD: 
        return 151.177222;
      // LONG
      case SZX: 
        return 113.812;
      case BCN: 
        return 2.078464;
      case GRU:
        return -46.469510; 
      case SHA:
        return 121.335; 
      case MCO:
        return -81.308999; 
      case TPE:
        return 121.232822; 
      case MEX:
        return -99.072096; 
      case KMG: 
        return 102.942;
      case EWR:
        return -74.168686; 
      case NRT:
        return 140.385556; 
      case MNL:
        return 121.019581; 
      case MSP:
        return -93.221777;
      default:
        return 0;
    }
  }
  
  // This enum allows for the
  // switch to be used
  public enum AirportCodes {
    ATL, PEK, DXB, ORD, HND, 
      LHR, LAX, HKG, CDG, DFW,
      IST, FRA, PVG, AMS, JFK,
      SIN, CAN, CGK, DEN, BKK, 
      SFO, ICN, KUL, MAD, DEL,
      LAS, CLT, MIA, PHX, IAH,
      SEA, CTU, YYZ, MUC, BOM,
      FCO, LGW, SYD, SZX, BCN,
      GRU, SHA, MCO, TPE, MEX,
      KMG, EWR, NRT, MNL, MSP,
      SAT
      
  }
}

