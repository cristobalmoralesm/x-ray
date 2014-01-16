package com.abien.xray.business.hits.boundary;

import com.abien.xray.business.hits.control.HitsManagement;
import com.abien.xray.business.monitoring.PerformanceAuditor;
import com.abien.xray.business.hits.entity.Hit;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author abien
 */
@Path("statistics")
@Stateless
@Interceptors(PerformanceAuditor.class)
public class StatisticsResource {

    @Inject
    HitsManagement hits;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Hit> totalHitsAsString(@QueryParam("exclude") String excludeContaining, @QueryParam("max") @DefaultValue("10") int max) {
        if (excludeContaining == null) {
            return hits.getMostPopularPosts(max);
        } else {
            return hits.getMostPopularPostsNotContaining(excludeContaining, max);
        }
    }
}
