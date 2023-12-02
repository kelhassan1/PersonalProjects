import { createApi, fetchBaseQuery } from '@reduxjs/toolkit/query/react';

export const shazamCoreApi = createApi({
 reducerPath: 'shazamCoreApi',
 baseQuery: fetchBaseQuery({
    baseUrl: 'https://shazam-core.p.rapidapi.com/v1',
    prepareHeaders: (headers) => {
        headers.set('X-RapidAPI-Key', '4b79c9103amsh5db45d7e782f03dp1c7e44jsn33a48f8abff5');
        return headers;
    }
    }),
    endpoints: (builder) => ({
        getTopCharts: builder.query({ query: () => '/charts/world' }),
    }),
});

export const{
    useGetTopChartsQuery,

} = shazamCoreApi;