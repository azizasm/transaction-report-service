/*
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 *
 * Created by Aziz SM on 1/13/19 12:49 AM.
 * Copyright (c) 2019.  All rights reserved.
 *
 */

package my.app.transreport.graphql;

import java.util.List;
import java.util.stream.Collectors;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import org.springframework.stereotype.Component;


@Component
public class GraphQLErrorHandler implements graphql.servlet.GraphQLErrorHandler {

    /**
     *  default processErrors
     * @param list
     * @return
     */
    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
       return list.stream().map(this::getNested).collect(Collectors.toList());
    }

    /**
     * Nested Error
     * @param error
     * @return
     */
    private GraphQLError getNested(GraphQLError error) {
        if (error instanceof ExceptionWhileDataFetching) {
            ExceptionWhileDataFetching exceptionError = (ExceptionWhileDataFetching) error;
            if (exceptionError.getException() instanceof GraphQLError) {
                return (GraphQLError) exceptionError.getException();
            }
        }
        return error;
    }

}
