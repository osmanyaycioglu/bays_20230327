package com.training.spring.bays.conf;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

//@Getter
//@Setter
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode

@NoArgsConstructor
public class MyDTO {

    private String  host;
    private Integer port;
    private String  path;
    private Integer period;
    //    @Override
    //    public String toString() {
    //        return "MyDTO [host=" + host + ", port=" + port + ", path=" + path + ", period=" + period + "]";
    //    }
    //    @Override
    //    public int hashCode() {
    //        return Objects.hash(host,
    //                            path,
    //                            period,
    //                            port);
    //    }
    //    @Override
    //    public boolean equals(Object obj) {
    //        if (this == obj)
    //            return true;
    //        if (obj == null)
    //            return false;
    //        if (getClass() != obj.getClass())
    //            return false;
    //        MyDTO other = (MyDTO) obj;
    //        return Objects.equals(host,
    //                              other.host)
    //               && Objects.equals(path,
    //                                 other.path)
    //               && Objects.equals(period,
    //                                 other.period)
    //               && Objects.equals(port,
    //                                 other.port);
    //    }

    //    public MyDTO() {
    //    }
    //
    //
    //    public MyDTO(String hostParam,
    //                 Integer portParam,
    //                 String pathParam,
    //                 Integer periodParam) {
    //        super();
    //        host = hostParam;
    //        port = portParam;
    //        path = pathParam;
    //        period = periodParam;
    //    }

}
